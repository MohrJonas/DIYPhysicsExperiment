package thu.mohr.jonas.physics

data class ValuePatternPart(
    val relationType: ValueRelationType, val nmin: Int, val nmax: Int, val minDiff: Double, val maxDiff: Double
) {

    fun matches(relation: ValueRelation): Boolean {
        return relation.relationType == relationType && (relation.differenceAbs in minDiff..maxDiff)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ValuePatternPart

        if (relationType != other.relationType) return false
        if (nmin != other.nmin) return false
        if (nmax != other.nmax) return false
        if (minDiff != other.minDiff) return false
        if (maxDiff != other.maxDiff) return false

        return true
    }

    override fun hashCode(): Int {
        var result = relationType.hashCode()
        result = 31 * result + nmin
        result = 31 * result + nmax
        result = 31 * result + minDiff.hashCode()
        result = 31 * result + maxDiff.hashCode()
        return result
    }

    override fun toString(): String {
        return "ValuePatternPart(relationType=$relationType, nmin=$nmin, nmax=$nmax, minDiff=$minDiff, maxDiff=$maxDiff)"
    }

}
