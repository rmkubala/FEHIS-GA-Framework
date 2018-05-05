package pl.polsl.ga

import pl.polsl.ga.general.GeneticAlgorithm
import pl.polsl.ga.impl.BasicIndividual

fun main(args: Array<String>) {
    val geneticAlgorithm = GeneticAlgorithm({ BasicIndividual() })

    geneticAlgorithm.run()
}