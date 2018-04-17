package pl.polsl.ga.general

abstract class Selector {
    abstract fun <T : Individual<*>> drawIndividuals(population: ArrayList<T>): ArrayList<T>
}