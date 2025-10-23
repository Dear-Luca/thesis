Collektive(
    deviceId,
    MqttMailbox(...),
) {
    // aggregate program runs on top of this engine
    val neighborMap = neighboring(localId)
    val result = share(...) { ... }
    val allSourceMessages = chatMultipleSources(...)
}