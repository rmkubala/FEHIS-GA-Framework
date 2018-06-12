package pl.polsl.ga.example

import pl.polsl.ga.general.GeneticAlgorithm
import pl.polsl.ga.general.Individual
import pl.polsl.ga.general.RandHelper
import pl.polsl.ga.impl.BinaryGenomeManipulator
import pl.polsl.ga.impl.CountingStopCondition

fun main(args: Array<String>) {


    val geneticAlgorithm = GeneticAlgorithm(
            { Individual(RandHelper.RANDOM.nextLong()) },
            FitnessCalculator::calculateFitness,
            BinaryGenomeManipulator(),
            stopCondition = CountingStopCondition(1000)
    )

    geneticAlgorithm.run()

    println("Best individual: ${geneticAlgorithm.getBestIndividual()}")
    println("The path: ${FitnessCalculator.getPath(geneticAlgorithm.getBestIndividual().genome)}")
}