package pl.polsl.ga.general

abstract class Mutator {
    abstract fun mutate(crossedOverIndividuals: ArrayList<Individual>): ArrayList<Individual>

}
