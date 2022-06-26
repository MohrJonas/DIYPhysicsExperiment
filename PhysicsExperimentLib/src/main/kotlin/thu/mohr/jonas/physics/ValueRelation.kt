package thu.mohr.jonas.physics

import kotlin.math.abs

class ValueRelation(
    val firstValue: Double,
    val secondValue: Double,
    val firstValueTime: Double? = null,
    val secondValueTime: Double? = null
) {

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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ValueRelation

        if (firstValue != other.firstValue) return false
        if (secondValue != other.secondValue) return false
        if (firstValueTime != other.firstValueTime) return false
        if (secondValueTime != other.secondValueTime) return false
        if (relationType != other.relationType) return false
        if (differenceReal != other.differenceReal) return false
        if (differenceAbs != other.differenceAbs) return false

        return true
    }

    override fun hashCode(): Int {
        var result = firstValue.hashCode()
        result = 31 * result + secondValue.hashCode()
        result = 31 * result + (firstValueTime?.hashCode() ?: 0)
        result = 31 * result + (secondValueTime?.hashCode() ?: 0)
        result = 31 * result + relationType.hashCode()
        result = 31 * result + differenceReal.hashCode()
        result = 31 * result + differenceAbs.hashCode()
        return result
    }

    override fun toString(): String {
        return "ValueRelation(firstValue=$firstValue, secondValue=$secondValue, firstValueTime=$firstValueTime, secondValueTime=$secondValueTime, relationType=$relationType, differenceReal=$differenceReal, differenceAbs=$differenceAbs)"
    }

}