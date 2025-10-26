@Serializable
data class DeviceLocationHeartbeat(
    val deviceId: String,           
    val location: DeviceLocation?,  
    val timestamp: Long,            
)