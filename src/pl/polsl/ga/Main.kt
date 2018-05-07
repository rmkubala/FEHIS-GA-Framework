package pl.polsl.ga

import pl.polsl.ga.general.GeneticAlgorithm
import pl.polsl.ga.general.Individual
import pl.polsl.ga.general.RandHelper
import pl.polsl.ga.impl.BinaryGenomeManipulator
import pl.polsl.ga.impl.CountingStopCondition

fun main(args: Array<String>) {
    val geneticAlgorithm = GeneticAlgorithm(
            { Individual(RandHelper.RANDOM.nextLong()) },
            { i: Individual<Long> -> i.fitness = 1 + i.genome / Long.MAX_VALUE.toDouble() },
            BinaryGenomeManipulator(),
            stopCondition = CountingStopCondition(5000)
    )

    geneticAlgorithm.run()

    println("Best individual: ${geneticAlgorithm.getBestIndividual()}")
}