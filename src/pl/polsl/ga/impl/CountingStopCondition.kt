package pl.polsl.ga.impl

import pl.polsl.ga.general.Individual
import pl.polsl.ga.general.StopCondition

class CountingStopCondition : StopCondition() {
    override fun <T : Individual<*>> shouldContinue(population: ArrayList<T>, generation: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}