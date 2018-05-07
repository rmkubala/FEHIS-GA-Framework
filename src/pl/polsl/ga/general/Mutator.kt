package pl.polsl.ga.general

abstract class Mutator<T> {

    lateinit var genomeManipulator: GenomeManipulator<T>

    abstract fun mutate(crossedOverIndividuals: ArrayList<Individual<T>>): ArrayList<Individual<T>>

}
