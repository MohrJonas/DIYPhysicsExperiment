package thu.mohr.jonas.physics

class ValuePattern(vararg val patternParts: ValuePatternPart) {

    fun matches(relations: List<ValueRelation>): Boolean {
        var mutatedRelations = relations
        patternParts.forEach { patternPart ->
            mutatedRelations =
                relations.dropWhile { relation -> patternPart.matches(relation) }
            val dropped = relations.size - mutatedRelations.size
            if (dropped < patternPart.nmin || dropped >= patternPart.nmax) return false
        }
        return mutatedRelations.isEmpty()
    }

}