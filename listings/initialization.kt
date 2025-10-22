val isTargetNode = localId == target
    
val localContent = if (isTargetNode && isSource) content else ""
    
val localDistance = if (isTargetNode) 0.0 else Double.POSITIVE_INFINITY

val localGossip = GossipGradient(
        distance = localDistance,
        localDistance = localDistance,
        content = localContent,
        path = listOf(localId),
    )