package pl.polsl.ga.general

abstract class StopCondition {
    abstract fun <T : Individual<*>> shouldContinue(population: ArrayList<T>, generation: Int): Boolean
}
