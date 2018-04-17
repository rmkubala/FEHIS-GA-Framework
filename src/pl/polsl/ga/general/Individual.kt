package pl.polsl.ga.general

abstract class Individual<T : Genome>(genomeFactory: () -> T) {
    var fitness = 0.0
    val genome: T = genomeFactory.invoke()

    abstract fun updateFitness()

    abstract fun initialize()
}