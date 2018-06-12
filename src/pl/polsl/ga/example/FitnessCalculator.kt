package pl.polsl.ga.example

import pl.polsl.ga.general.Individual

object FitnessCalculator {
    private const val graphNodesCount = 6

    // Lazy init the graph variable
    private val graph: Array<IntArray> by lazy {
        val graph = Array(graphNodesCount, { IntArray(graphNodesCount, { 0 }) })

        // Fill in the graph
        // 0 -> 1 -> 3 -> 5
        // |         |    ^
        // ---> 2 -> 4 ---|

        // Always node 0 is start and graphNodesCount -1 is the end


        graph[0][1] = 20
        graph[1][3] = 5
        graph[3][5] = 3

        graph[3][4] = 1

        graph[0][2] = 10
        graph[2][4] = 11
        graph[4][5] = 7
        graph
    }


    /**
     * Returns the fitness of individual. The genome is a true false (1 or 0) string
     * of bits where bit at position 0 indicates whether to go from node 0 to 0,
     * 1 to go from node 0 to 1 etc
     */
    fun calculateFitness(individual: Individual<Long>) {
        var distance = 0

        val path = getPath(individual.genome)
        if (!path.isEmpty()) {

            // Check if got to the end of graph
            if (path[path.size - 1].second != (graphNodesCount - 1)) {
                // Penalize for that
                distance += 1000
            }

            // Check if started from 0th node
            if (path[0].first != 0) {
                // Penalize for that
                distance += 1000
            }

            // Check if is continous
            for (i in 0 until path.size - 1) {
                if (path[i].second != path[i + 1].first) {
                    distance += 1000
                }
            }

            // Calcualte distance
            for ((a, b) in path) {
                val disBetweenNodes = graph[a][b]
                distance += if (disBetweenNodes > 0) disBetweenNodes else 1000
            }
        } else {
            distance = 999999
        }

        individual.fitness = 1 / distance.toDouble()
    }

    private fun getBitAt(l: Long, position: Int): Boolean = (l shr position) and 1 > 0


    fun getPath(l: Long): List<Pair<Int, Int>> {
        val path = ArrayList<Pair<Int, Int>>()
        for (i in 0 until graphNodesCount) {
            for (j in 0 until graphNodesCount) {
                val genePosition = i * graphNodesCount + j
                val isSet = getBitAt(l, genePosition)
                if (isSet) {
                    path.add(Pair(i, j))
                    break
                }
            }
        }
        return path
    }


}
