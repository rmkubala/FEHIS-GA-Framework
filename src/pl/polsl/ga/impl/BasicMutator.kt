package pl.polsl.ga.impl

import pl.polsl.ga.general.Individual
import pl.polsl.ga.general.Mutator
import pl.polsl.ga.general.RandHelper

class BasicMutator<T> : Mutator<T>() {
    override fun mutate(crossedOverIndividuals: ArrayList<Individual<T>>): ArrayList<Individual<T>> {
        val genotypeLen = genomeManipulator.getLength()

        crossedOverIndividuals.forEach { it.genome = genomeManipulator.flipBitAt(it.genome, RandHelper.RANDOM.nextInt(genotypeLen)) }

        return crossedOverIndividuals
    }
}