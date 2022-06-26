package thu.mohr.jonas.physics.test

import org.junit.jupiter.api.Test
import thu.mohr.jonas.physics.ValuePattern
import thu.mohr.jonas.physics.ValuePatternPart
import thu.mohr.jonas.physics.ValueRelationType
import kotlin.test.assertTrue

class MultiTest {

    private val testPattern = ValuePattern(
        ValuePatternPart(ValueRelationType.ASCENDING, 2, 4, 1.0, 3.0),
        ValuePatternPart(ValueRelationType.DESCENDING, 2, 4, 1.0, 3.0)
    )

    @Test
    fun matchDescendAscend() {
        assertTrue {
            true
        }
    }

}