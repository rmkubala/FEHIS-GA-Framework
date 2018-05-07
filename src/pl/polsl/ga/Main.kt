package pl.polsl.ga

import pl.polsl.ga.general.GeneticAlgorithm
import pl.polsl.ga.general.Individual
import pl.polsl.ga.general.RandHelper
import pl.polsl.ga.impl.BinaryGenomeManipulator

fun main(args: Array<String>) {
    val geneticAlgorithm = GeneticAlgorithm(
            { Individual(RandHelper.RANDOM.nextLong()) },
            { i: Individual<Long> -> i.fitness = i.genome / Long.MAX_VALUE.toDouble() },
            BinaryGenomeManipulator())

    geneticAlgorithm.run()
}