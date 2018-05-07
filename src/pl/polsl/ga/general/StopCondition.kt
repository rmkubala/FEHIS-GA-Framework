package pl.polsl.ga.general

abstract class StopCondition {
    abstract fun shouldContinue(population: ArrayList<Individual<Any>>, generation: Int): Boolean
}
