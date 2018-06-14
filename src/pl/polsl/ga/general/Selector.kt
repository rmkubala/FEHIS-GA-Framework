package pl.polsl.ga.general

import java.util.*

/**
 * Should select individuals from population to be later crossed over and mutated
 */
abstract class Selector<T> {
    /**
     * @return individuals selected for breeding
     */
    abstract fun drawIndividuals(population: ArrayList<Individual<T>>): ArrayList<Individual<T>>
}