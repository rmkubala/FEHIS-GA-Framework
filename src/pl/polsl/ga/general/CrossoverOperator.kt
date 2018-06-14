package pl.polsl.ga.general

/**
 * This abstract class should perform the crossover operation on the list of
 * selected individuals.
 */
abstract class CrossoverOperator<T> {

    /**
     * Genome manipulator for operations on individual's genome.
     * It will be supplied by [GeneticAlgorithm]
     */
    lateinit var genomeManipulator: GenomeManipulator<T>

    /**
     * Function that performs the crossover on the selected individuals.
     * @return list of crossed over individuals
     */
    abstract fun crossover(selectedIndividuals: ArrayList<Individual<T>>): ArrayList<Individual<T>>
}