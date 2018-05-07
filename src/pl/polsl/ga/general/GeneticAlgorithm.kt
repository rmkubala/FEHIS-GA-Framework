package pl.polsl.ga.general

import pl.polsl.ga.impl.BasicMutator
import pl.polsl.ga.impl.BasicSelector
import pl.polsl.ga.impl.CountingStopCondition
import pl.polsl.ga.impl.SinglePointCrossoverOperator

class GeneticAlgorithm<T>(private val individualFactory: () -> Individual<T>,
                          private val fitnessUpdater: (Individual<T>) -> Unit,
                          private val genomeManipulator: GenomeManipulator<T>,
                          private val selector: Selector<T> = BasicSelector(),
                          private val crossoverOperator: CrossoverOperator<T> = SinglePointCrossoverOperator(),
                          private val mutator: Mutator<T> = BasicMutator(),
                          private val stopCondition: StopCondition = CountingStopCondition(1000),
                          private val populationSize: Int = 1000) {

    private var population: ArrayList<Individual<T>> = ArrayList()
    var generation = 0

    init {
        crossoverOperator.genomeManipulator = genomeManipulator
        mutator.genomeManipulator = genomeManipulator
    }

    fun run() {
        // Restart the generation counter
        generation = 0
        // Initialize the population with random data
        initializePopulation()
        // Run until the stop condition is reached
        while (stopCondition.shouldContinue(population as ArrayList<Individual<Any>>, generation)) {
            // Update fitness of every individual in the population
            updatePopulationFitness()

            // Selector the individuals that will take part in the crossoverOperator
            val selectedIndividuals = selector.drawIndividuals(population)

            // Subject the selected individuals to the crossoverOperator
            val crossedOverIndividuals = crossoverOperator.crossover(selectedIndividuals)

            // Mutator individuals and create a new population
            population = mutator.mutate(crossedOverIndividuals)

            generation++
        }

    }

    private fun initializePopulation() {
        for (i in 0 until populationSize) {
            val individual = individualFactory.invoke()
            population.add(individual)
        }
    }

    private fun updatePopulationFitness() {
        population.forEach { i: Individual<T> -> fitnessUpdater.invoke(i) }
    }
}