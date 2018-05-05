package pl.polsl.ga.impl

import pl.polsl.ga.general.Genome
import pl.polsl.ga.general.Individual

class BasicIndividual(fitness: Double = 0.0, accumulatedNormalizedFitness: Double = 0.0, genome: Genome<Any> = BinaryGenome() as Genome<Any>) :
        Individual(genome, fitness, accumulatedNormalizedFitness) {


    override fun updateFitness() {

    }

    override fun initialize() {

    }

    override fun copy(): Individual {
        return BasicIndividual(this.fitness, this.accumulatedNormalizedFitness, this.genome)
    }

}