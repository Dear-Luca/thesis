val messages = mutableMapOf<Int, Message>()
    for (sourceId in sources) {
        alignedOn(sourceId) {
            val result = gossipGradient(
                distances = distances,
                target = sourceId,
                isSource = localId == sourceId && isSource,
                currentTime = currentTime,
                content = content,
                lifeTime = lifeTime,
                maxDistance = maxDistance,
            )

            result?.let { messages[sourceId] = result }
        }
    }