package pl.polsl.ga.impl

import pl.polsl.ga.general.CrossoverOperator
import pl.polsl.ga.general.Individual
import pl.polsl.ga.general.RandHelper

class SinglePointCrossoverOperator<T> : CrossoverOperator<T>() {
    override fun crossover(selectedIndividuals: ArrayList<Individual<T>>): ArrayList<Individual<T>> {
        val result = ArrayList<Individual<T>>()

        var i = 0
        while (i < selectedIndividuals.size) {
            val (child1, child2) = cross(selectedIndividuals[i], selectedIndividuals[i + 1])
            result.add(child1)
            result.add(child2)
            i += 2
        }

        return result
    }

    private fun cross(i1: Individual<T>, i2: Individual<T>): Pair<Individual<T>, Individual<T>> {
        val genomeLength = genomeManipulator.getLength()

        val crossoverPoint = RandHelper.RANDOM.nextInt(genomeLength)
        val child1 = i1.copy()
        val child2 = i2.copy()

        child1.genome = genomeManipulator.plus(
                genomeManipulator.getSegment(i1.genome, 0, crossoverPoint),
                genomeManipulator.getSegment(i2.genome, crossoverPoint, genomeLength)
        )

        child2.genome = genomeManipulator.plus(
                genomeManipulator.getSegment(i2.genome, 0, crossoverPoint),
                genomeManipulator.getSegment(i1.genome, crossoverPoint, genomeLength)
        )

        return Pair(child1, child2)
    }
}