val isTargetNode = localId == target
    
val localContent = if (isTargetNode && isSource) content else ""
    
val localDistance = if (isTargetNode) 0.0 else Double.POSITIVE_INFINITY