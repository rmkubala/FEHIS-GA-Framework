package pl.polsl.ga.general

class Individual<T>(var genome: T, var fitness: Double = 0.0, var accumulatedNormalizedFitness: Double = 0.0)
    : Comparable<Individual<*>> {

    override fun compareTo(other: Individual<*>): Int {
        return this.fitness.compareTo(other.fitness)
    }

    fun copy(): Individual<T> {
        return Individual(genome, this.fitness, this.accumulatedNormalizedFitness)
    }
}