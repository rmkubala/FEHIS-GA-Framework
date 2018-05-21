package pl.polsl.ga.general

import pl.polsl.ga.impl.BasicMutator
import pl.polsl.ga.impl.BasicSelector
import pl.polsl.ga.impl.CountingStopCondition
import pl.polsl.ga.impl.SinglePointCrossoverOperator

/**
 * Main algorithm class
 *
 * @param individualFactory - function which creates a single individual
 * @param fitnessUpdater - function which updates single individual's fitness score
 * @param genomeManipulator - an instance of [GenomeManipulator] compatible with individual's genome
 * @param selector - an instance of [Selector] which selects individuals from population
 * @param crossoverOperator - an instance of [CrossoverOperator] for Crossover stage
 * @param mutator - an instance of [Mutator] for Mutation stage
 * @param stopCondition - an instance of [StopCondition] which determines when to stop the algorithm
 * @param populationSize - number of individuals in population
 */
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

    /**
     * Runs the algorithm until [stopCondition.shouldContinue()] returns false
     */
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

    fun getBestIndividual(): Individual<T> {
        population.sortDescending()
        return population[0]
    }
}