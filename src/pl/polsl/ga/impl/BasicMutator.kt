package pl.polsl.ga.impl

import pl.polsl.ga.general.Individual
import pl.polsl.ga.general.Mutator
import pl.polsl.ga.general.RandHelper

class BasicMutator : Mutator() {
    override fun mutate(crossedOverIndividuals: ArrayList<Individual>): ArrayList<Individual> {
        val genotypeLen = crossedOverIndividuals[0].genome.getLength()

        crossedOverIndividuals.forEach { it.genome.flipBitAt(RandHelper.RANDOM.nextInt(genotypeLen)) }

        return crossedOverIndividuals
    }
}