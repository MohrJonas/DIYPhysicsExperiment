package thu.mohr.jonas.physics.test

import org.junit.jupiter.api.Test
import thu.mohr.jonas.physics.ValuePattern
import thu.mohr.jonas.physics.ValuePatternPart
import thu.mohr.jonas.physics.ValueRelation
import thu.mohr.jonas.physics.ValueRelationType
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Tests {

    private val testPattern = ValuePattern(ValuePatternPart(ValueRelationType.ASCENDING, 2, 4, 1.0, 3.0))

    @Test
    fun matchPattern() {
        assertTrue {
            testPattern.matches(
                listOf(
                    ValueRelation(1.0, 3.0), ValueRelation(3.0, 4.0), ValueRelation(5.0, 8.0)
                )
            )
        }
    }

    @Test
    fun matchJustEnough() {
        assertTrue {
            testPattern.matches(
                listOf(
                    ValueRelation(1.0, 3.0), ValueRelation(3.0, 5.0)
                )
            )
        }
    }

    @Test
    fun failMatchNotEnough() {
        assertFalse {
            testPattern.matches(
                listOf(
                    ValueRelation(1.0, 3.0)
                )
            )
        }
    }

    @Test
    fun failMatchEmpty() {
        assertFalse {
            testPattern.matches(
                emptyList()
            )
        }
    }

    @Test
    fun failMatchTooMany() {
        assertFalse {
            testPattern.matches(
                listOf(
                    ValueRelation(1.0, 3.0),
                    ValueRelation(3.0, 5.0),
                    ValueRelation(5.0, 7.0),
                    ValueRelation(7.0, 9.0),
                    ValueRelation(9.0, 11.0),
                    ValueRelation(11.0, 13.0),
                    ValueRelation(13.0, 15.0)
                )
            )
        }
    }

    @Test
    fun failMatchJustTooMany() {
        assertFalse {
            testPattern.matches(
                listOf(
                    ValueRelation(1.0, 3.0),
                    ValueRelation(3.0, 5.0),
                    ValueRelation(5.0, 7.0),
                    ValueRelation(7.0, 9.0),
                    ValueRelation(9.0, 11.0)
                )
            )
        }
    }

    @Test
    fun failMatchAlmostTooMany() {
        assertFalse {
            testPattern.matches(
                listOf(
                    ValueRelation(1.0, 3.0), ValueRelation(3.0, 5.0), ValueRelation(5.0, 7.0), ValueRelation(7.0, 9.0)
                )
            )
        }
    }

    @Test
    fun failMatchTooSmallDiff() {
        assertFalse {
            testPattern.matches(
                listOf(
                    ValueRelation(1.0, 1.1),
                    ValueRelation(3.0, 5.0),
                )
            )
        }
    }

    @Test
    fun failMatchJustTooSmallDiff() {
        assertFalse {
            testPattern.matches(
                listOf(
                    ValueRelation(1.0, 1.9),
                    ValueRelation(3.0, 5.0),
                )
            )
        }
    }

    @Test
    fun failMatchAlmostTooSmallDiff() {
        assertTrue {
            testPattern.matches(
                listOf(
                    ValueRelation(1.0, 2.0),
                    ValueRelation(3.0, 5.0),
                )
            )
        }
    }

    @Test
    fun failMatchTooBigDiff() {
        assertFalse {
            testPattern.matches(
                listOf(
                    ValueRelation(1.0, 40.0), ValueRelation(40.0, 42.0)
                )
            )
        }
    }

    @Test
    fun failMatchAlmostTooBigDiff() {
        assertTrue {
            testPattern.matches(
                listOf(
                    ValueRelation(1.0, 4.0), ValueRelation(40.0, 42.0)
                )
            )
        }
    }

    @Test
    fun failMatchJustTooBigDiff() {
        assertFalse {
            testPattern.matches(
                listOf(
                    ValueRelation(1.0, 4.1), ValueRelation(40.0, 42.0)
                )
            )
        }
    }

    @Test
    fun failMatchWrongRelationType() {
        assertFalse {
            testPattern.matches(
                listOf(
                    ValueRelation(40.0, 42.0), ValueRelation(1.0, 40.0)
                )
            )
        }
    }
}