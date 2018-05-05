package pl.polsl.ga.general

abstract class Selector {
    abstract fun drawIndividuals(population: ArrayList<Individual>): ArrayList<Individual>
}