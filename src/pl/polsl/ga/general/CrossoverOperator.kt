package pl.polsl.ga.general

abstract class CrossoverOperator {
    abstract fun crossover(selectedIndividuals: ArrayList<Individual>): ArrayList<Individual>
}