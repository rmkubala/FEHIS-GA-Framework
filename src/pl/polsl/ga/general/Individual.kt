package pl.polsl.ga.general

/**
 * Representation of a single individual in a population
 */
class Individual<T>(
        var genome: T,
        var fitness: Double = 0.0,
        var accumulatedNormalizedFitness: Double = 0.0)
    : Comparable<Individual<*>> {

    /**
     * Compare fitness scores of 2 individuals
     */
    override fun compareTo(other: Individual<*>): Int {
        return this.fitness.compareTo(other.fitness)
    }

    /**
     * Performs a copy operation
     */
    fun copy(): Individual<T> {
        return Individual(genome, this.fitness, this.accumulatedNormalizedFitness)
    }

    override fun toString(): String {
        return "Individual(genome=$genome, fitness=$fitness, accumulatedNormalizedFitness=$accumulatedNormalizedFitness)"
    }


}