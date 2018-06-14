package pl.polsl.ga.general

/**
 * This class is responsible for mutation of the individual's genomes
 */
abstract class Mutator<T> {

    /**
     * Genome manipulator for operations on individual's genome.
     * It will be supplied by [GeneticAlgorithm]
     */
    lateinit var genomeManipulator: GenomeManipulator<T>

    /**
     * @return the list of mutated individuals
     */
    abstract fun mutate(crossedOverIndividuals: ArrayList<Individual<T>>): ArrayList<Individual<T>>

}
