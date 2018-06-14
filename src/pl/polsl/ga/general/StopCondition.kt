package pl.polsl.ga.general

abstract class StopCondition {
    /**
     * @return true if the GA should continue, false otherwise
     */
    abstract fun shouldContinue(population: ArrayList<Individual<Any>>, generation: Int): Boolean
}
