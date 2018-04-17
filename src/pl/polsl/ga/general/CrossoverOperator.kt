package pl.polsl.ga.general

abstract class CrossoverOperator {
    abstract fun <T : Individual<*>> crossover(selectedIndividuals: ArrayList<T>): ArrayList<T>
}