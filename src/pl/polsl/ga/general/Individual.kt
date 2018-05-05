package pl.polsl.ga.general

abstract class Individual(val genome: Genome, var fitness: Double = 0.0, var accumulatedNormalizedFitness: Double = 0.0)
    : Comparable<Individual> {


    abstract fun updateFitness()

    abstract fun initialize()

    override fun compareTo(other: Individual): Int {
        return this.fitness.compareTo(other.fitness)
    }

    abstract fun copy(): Individual
}