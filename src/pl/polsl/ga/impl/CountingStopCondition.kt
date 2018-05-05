package pl.polsl.ga.impl

import pl.polsl.ga.general.Individual
import pl.polsl.ga.general.StopCondition

class CountingStopCondition(private val generationCount: Int) : StopCondition() {
    override fun shouldContinue(population: ArrayList<Individual>, generation: Int): Boolean {
        return generation < generationCount
    }
}