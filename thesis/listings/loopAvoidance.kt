val recentPath = neighborGossip.path.asReversed().drop(1)

val pathIsValid = recentPath.none { it == localId || it in neighbors }

val nextGossip = if (pathIsValid) neighborGossip else neighborGossip.base(neighborId)