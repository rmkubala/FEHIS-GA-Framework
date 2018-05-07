package pl.polsl.ga.general

abstract class CrossoverOperator<T> {

    lateinit var genomeManipulator: GenomeManipulator<T>

    abstract fun crossover(selectedIndividuals: ArrayList<Individual<T>>): ArrayList<Individual<T>>
}