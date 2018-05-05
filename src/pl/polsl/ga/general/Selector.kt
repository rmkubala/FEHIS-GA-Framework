package pl.polsl.ga.general

import java.util.*

abstract class Selector {


    abstract fun drawIndividuals(population: ArrayList<Individual>): ArrayList<Individual>
}