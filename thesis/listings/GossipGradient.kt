data class GossipGradient<ID : Comparable<ID>>(
    val distance: Double,
    val localDistance: Double,
    val content: String,
    val path: List<ID> = emptyList(),
) {
    /**
     * Reset gossip to start from the local value of the specified node [id].
     */
    fun base(id: ID) = GossipGradient(localDistance, localDistance, content, listOf(id))

    /**
     * Add a new hop [id] to the path, update the distance with [newBest] and the
     * localDistance with [localDistance].
     */
    fun addHop(newBest: Double, localDistance: Double, id: ID) = GossipGradient(
        distance = newBest,
        localDistance = localDistance,
        content = content,
        path = path + id,
    )
}