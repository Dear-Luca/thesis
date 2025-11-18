fun Aggregate<Int>.gossipGradient(
    distances: Field<Int, Double>,
    target: Int,
    isSource: Boolean,
    currentTime: Double,
    content: String,
    lifeTime: Double,
    maxDistance: Double,
): Message? {
    
    val isTargetNode = localId == target
    
    val localContent = if (isTargetNode && isSource) content else ""
    
    val localDistance = if (isTargetNode) 0.0 else Double.POSITIVE_INFINITY
    val localGossip = GossipGradient(
        distance = localDistance,
        localDistance = localDistance,
        content = localContent,
        path = listOf(localId),
    )

    val distanceMap = distances.toMap()
    val result = share(localGossip) { neighborsGossip: Field<Int, GossipGradient<Int>> ->
        var bestGossip = localGossip
        val neighbors = neighborsGossip.toMap().keys

        for ((neighborId, neighborGossip) in neighborsGossip.toMap()) {
            val recentPath = neighborGossip.path.asReversed().drop(1)
            val pathIsValid = recentPath.none { it == localId || it in neighbors }
            val nextGossip = if (pathIsValid) neighborGossip else neighborGossip.base(neighborId)
            val totalDistance = nextGossip.distance + distanceMap.getOrDefault(neighborId, nextGossip.distance)
            if (totalDistance < bestGossip.distance && neighborGossip.content.isNotEmpty()) {
                bestGossip = nextGossip.addHop(totalDistance, localGossip.localDistance, localId)
            }
        }
        bestGossip
    }

    val message = Message(result.content, result.distance)

    return message.takeIf {
        currentTime <= lifeTime &&
            result.distance < maxDistance &&
            result.distance.isFinite() &&
            result.content.isNotEmpty() &&
            localId != target
    }
}
