package pl.polsl.ga.impl

import pl.polsl.ga.general.CrossoverOperator
import pl.polsl.ga.general.Individual
import pl.polsl.ga.general.RandHelper

class SinglePointCrossoverOperator : CrossoverOperator() {
    override fun crossover(selectedIndividuals: ArrayList<Individual>): ArrayList<Individual> {
        val result = ArrayList<Individual>()

        var i = 0
        while (i < selectedIndividuals.size) {
            val (child1, child2) = cross(selectedIndividuals[i], selectedIndividuals[i + 1])
            result.add(child1)
            result.add(child2)
            i += 2
        }

        return result
    }

    private fun cross(i1: Individual, i2: Individual): Pair<Individual, Individual> {
        val genomeLength = i1.genome.getLength()

        val crossoverPoint = RandHelper.RANDOM.nextInt(genomeLength)
        val child1 = i1.copy()
        val child2 = i2.copy()

        child1.genome.genotype = i1.genome.getSegment(0, crossoverPoint).plus(i2.genome.getSegment(crossoverPoint, genomeLength)).genotype!!
        child2.genome.genotype = i2.genome.getSegment(0, crossoverPoint).plus(i1.genome.getSegment(crossoverPoint, genomeLength)).genotype!!

        return Pair(child1, child2)
    }
}