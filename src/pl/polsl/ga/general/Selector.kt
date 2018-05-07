package pl.polsl.ga.general

import java.util.*

abstract class Selector<T> {
    abstract fun drawIndividuals(population: ArrayList<Individual<T>>): ArrayList<Individual<T>>
}