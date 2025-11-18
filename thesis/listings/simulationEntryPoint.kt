fun Aggregate<Int>.gossipChatMultipleSourcesEntrypoint(
    environment: EnvironmentVariables,
    distanceSensor: CollektiveDevice<*>,
): String {
    val distances: Field<Int, Double> = with(distanceSensor) { distances() }
    val isSource = environment.get<Boolean>("source")
    val currentTime = distanceSensor.currentTime.toDouble()

    return chatMultipleSources(
        distances,
        isSource,
        currentTime,
    ).map { "${it.key}: ${it.value.content}" }
        .joinToString("\n")
}