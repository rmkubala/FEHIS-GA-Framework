package pl.polsl.ga.general

abstract class Mutator {
    abstract fun <T : Individual<*>> mutate(crossedOverIndividuals: ArrayList<T>): ArrayList<T>

}
