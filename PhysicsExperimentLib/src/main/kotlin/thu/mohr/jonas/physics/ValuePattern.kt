package thu.mohr.jonas.physics

class ValuePattern(vararg val patternParts: ValuePatternPart) {

    fun matches(relations: List<ValueRelation>): Boolean {
        if (relations.size < patternParts.sumOf { part -> part.nmin }) return false
        var mutRelations = relations.toMutableList()
        patternParts.forEach { patternPart ->
            val startSize = mutRelations.size
            mutRelations = mutRelations.dropWhile { relation -> patternPart.matches(relation) }.toMutableList()
            val sizeDiff = startSize - mutRelations.size
            if (sizeDiff < patternPart.nmin || sizeDiff > patternPart.nmax) return false
        }
        return mutRelations.isEmpty()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ValuePattern

        if (!patternParts.contentEquals(other.patternParts)) return false

        return true
    }

    override fun hashCode(): Int {
        return patternParts.contentHashCode()
    }

    override fun toString(): String {
        return "ValuePattern(patternParts=${patternParts.contentToString()})"
    }

}