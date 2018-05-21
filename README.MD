# Genetic Algoritm framework
**FEHIS project 2018**

## Section members
1. Hiacynta Sciborska
2. Katarzyna Szymanek
3. Maaz Ashiq
4. Radoslaw Kubala

## Aim of the project
This Framework should provide an easy way of creating Genetic Algorithms and provide the basic functionality out of the box. The project should contain a simple example of usage.

## Project implementation
The project was implemented in Kotlin programming language and can be used in both Kotlin and Java. The project contains two packages:

1. ```pl.polsl.ga.general``` - Contains all generic and abstract classes

2. ```pl.polsl.ga.impl``` - Contains implementations of the classes from the ```.general``` package which can be used for other applications

## Usage

```kotlin
val geneticAlgorithm = GeneticAlgorithm(
            { Individual(RandHelper.RANDOM.nextLong()) },
            { i: Individual<Long> -> i.fitness = 1 + i.genome / Long.MAX_VALUE.toDouble() },
            BinaryGenomeManipulator(),
            stopCondition = CountingStopCondition(5000)
    )

geneticAlgorithm.run()
println("Best individual: ${geneticAlgorithm.getBestIndividual()}")
```
Output
```
Best individual: Individual(genome=8646911284551352320, fitness=1.9375, accumulatedNormalizedFitness=0.012000281531531529) 
```


