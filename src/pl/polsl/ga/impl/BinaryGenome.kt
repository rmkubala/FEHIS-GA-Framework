package pl.polsl.ga.impl

import pl.polsl.ga.general.Genome

/**
 * The genotype is of type Long so the maximum Bit count is 64 bits
 */
class BinaryGenome : Genome() {
    var genotype: Long = RANDOM.nextLong()
}