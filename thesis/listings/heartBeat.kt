private suspend fun sendHeartbeatPulse() {
    ...
    mqttClient?.publish(
        retain = false,
        qos = Qos.AT_MOST_ONCE,
        topic = heartbeatTopic(deviceId),
        payload = payload,
    )
    delay(1.seconds)
    sendHeartbeatPulse()
}