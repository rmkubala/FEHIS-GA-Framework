package pl.polsl.ga.impl

import pl.polsl.ga.general.Genome
import pl.polsl.ga.general.RandHelper

/**
 * The genotype is of type Long so the maximum Bit count is 64 bits
 */
class BinaryGenome : Genome<Long>() {
    override fun plus(other: Genome<*>): Genome<*> {
        val genome = BinaryGenome()
        genome.genotype = this.genotype or other.genotype as Long
        return genome
    }

    override var genotype: Long = RandHelper.RANDOM.nextLong()

    override fun getLength(): Int {
        return 64
    }

    override fun getSegment(start: Int, end: Int): Genome<Long> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return this
    }

    override fun flipBitAt(position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

