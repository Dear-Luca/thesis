return message.takeIf {
        currentTime <= lifeTime &&
            result.distance < maxDistance &&
            result.distance.isFinite() &&
            result.content.isNotEmpty() &&
            localId != target
    }