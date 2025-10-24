@Serializable
data class DeviceLocation(
    val latitude: Double,           
    val longitude: Double,
    val accuracy: Float?,
    val timestamp: Long
)