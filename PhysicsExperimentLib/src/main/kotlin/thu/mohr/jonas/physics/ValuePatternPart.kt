package thu.mohr.jonas.physics

data class ValuePatternPart(
    val relationType: ValueRelationType,
    val nmin: Int,
    val nmax: Int,
    val minDiff: Double,
    val maxDiff: Double
) {

    fun matches(relation: ValueRelation): Boolean {
        return relation.relationType == relationType && (relation.differenceAbs in minDiff..maxDiff)
    }

}
