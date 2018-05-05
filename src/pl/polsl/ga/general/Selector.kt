package pl.polsl.ga.general

import java.util.*

abstract class Selector {
    companion object {
        val RANDOM = Random()
    }

    abstract fun drawIndividuals(population: ArrayList<Individual>): ArrayList<Individual>
}