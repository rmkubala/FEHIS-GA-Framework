package pl.polsl.ga.general

import pl.polsl.ga.impl.BasicCrossoverOperator
import pl.polsl.ga.impl.BasicMutator
import pl.polsl.ga.impl.BasicSelector
import pl.polsl.ga.impl.CountingStopCondition

class GeneticAlgorithm<T : Individual<*>>(private val selector: Selector = BasicSelector(),
                                          private val crossoverOperator: CrossoverOperator = BasicCrossoverOperator(),
                                          private val mutator: Mutator = BasicMutator(),
                                          private val stopCondition: StopCondition = CountingStopCondition(),
                                          private val populationSize: Int = 1000) {

    private var population: ArrayList<T> = ArrayList(populationSize)
    var generation = 0


    fun run() {
        // Restart the generation counter
        generation = 0
        // Initialize the population with random data
        initializePopulation()
        // Run until the stop condition is reached
        while (stopCondition.shouldContinue(population, generation)) {
            // Update fitness of every individual in the population
            updatePopulationFitness()

            // Selector the individuals that will take part in the crossoverOperator
            val selectedIndividuals = selector.drawIndividuals(population)

            // Subject the selected individuals to the crossoverOperator
            val crossedOverIndividuals = crossoverOperator.crossover(selectedIndividuals)

            // Mutator individuals and create a new population
            population = mutator.mutate(crossedOverIndividuals)
        }

    }

    private fun initializePopulation() {
        population.forEach { i: T -> i.initialize() }
    }

    private fun updatePopulationFitness() {
        population.forEach { i: T -> i.updateFitness() }
    }
}