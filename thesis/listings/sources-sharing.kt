val localSources: Set<Int> = if (isSource) setOf(localId) else emptySet()
val sources: Set<Int> = share(localSources) { neighborSets: Field<Int, Set<Int>> ->
    neighborSets.neighborsValues.fold(localSources) { accumulator, neighborSet ->
        accumulator + neighborSet
    }
}