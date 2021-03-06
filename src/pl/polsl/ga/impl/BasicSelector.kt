package pl.polsl.ga.impl

import pl.polsl.ga.general.Individual
import pl.polsl.ga.general.RandHelper
import pl.polsl.ga.general.Selector

class BasicSelector<T> : Selector<T>() {
    override fun drawIndividuals(population: ArrayList<Individual<T>>): ArrayList<Individual<T>> {
        var sumOfFitnessScores = 0.0
        population.forEach { sumOfFitnessScores += it.fitness }

        population.sortDescending()

        //Normalize the fitness and store the accumulated fitness
        var accumulatedFitness = 0.0
        population.forEach {
            accumulatedFitness += (it.fitness / sumOfFitnessScores)
            it.accumulatedNormalizedFitness = accumulatedFitness
        }


        val selectedIndividuals = ArrayList<Individual<T>>()
        while (selectedIndividuals.size < population.size) {
            val rand = RandHelper.RANDOM.nextDouble()
            var selectedIndividualId = 0
            while (population[selectedIndividualId].accumulatedNormalizedFitness < rand) {
                selectedIndividualId++
            }
            selectedIndividuals.add(population[selectedIndividualId].copy())
        }

        return selectedIndividuals
    }
}