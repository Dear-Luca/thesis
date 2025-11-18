val totalDistance = nextGossip.distance + distanceMap.getOrDefault(neighborId, nextGossip.distance)
if (totalDistance < bestGossip.distance && neighborGossip.content.isNotEmpty()) {
    bestGossip = nextGossip.addHop(totalDistance, localGossip.localDistance, localId)
}