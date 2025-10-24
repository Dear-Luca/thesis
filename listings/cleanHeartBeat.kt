private suspend fun cleanHeartbeatPulse() {
    cleanupNeighbors(retentionTime)  
    delay(retentionTime)             
    cleanHeartbeatPulse()            
}