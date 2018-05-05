package pl.polsl.ga.impl

import pl.polsl.ga.general.Genome
import pl.polsl.ga.general.Individual

class BasicIndividual(fitness: Double = 0.0, accumulatedNormalizedFitness: Double = 0.0, genome: Genome = BinaryGenome()) :
        Individual(genome, fitness, accumulatedNormalizedFitness) {


    override fun updateFitness() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initialize() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun copy(): Individual {
        return BasicIndividual(this.fitness, this.accumulatedNormalizedFitness, this.genome)
    }

}