package thu.mohr.jonas.physics

import kotlin.math.abs

class ValueRelation(val firstValue: Double, val secondValue: Double, val firstValueTime: Double? = null, val secondValueTime: Double? = null) {

    val relationType: ValueRelationType
    val differenceReal = firstValue - secondValue
    val differenceAbs = abs(differenceReal)

    init {
        val comparisonResult = firstValue.compareTo(secondValue)
        relationType = when {
            (comparisonResult < 0) -> ValueRelationType.ASCENDING
            (comparisonResult > 0) -> ValueRelationType.DESCENDING
            else -> ValueRelationType.EQUAL
        }
    }

}