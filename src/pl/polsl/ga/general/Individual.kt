package pl.polsl.ga.general

abstract class Individual(val genome: Genome) {
    var fitness = 0.0

    abstract fun updateFitness()

    abstract fun initialize()
}