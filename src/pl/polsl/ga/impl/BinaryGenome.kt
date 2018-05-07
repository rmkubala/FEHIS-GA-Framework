package pl.polsl.ga.impl

import pl.polsl.ga.general.Genome
import pl.polsl.ga.general.RandHelper

/**
 * The genotype is of type Long so the maximum Bit count is 64 bits
 */
class BinaryGenome() : Genome<Long>() {
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
        // Mask is used to get only the interesting segment and zeros where needed
        // Example: start = 2, end = 10
        // Mask: 00111111110000000000000...
        var mask: Long = -1L ushr (end - start)
        mask = mask.inv()
        mask = mask ushr start

//        bitPattern(mask)

        return BinaryGenome(this.genotype and mask)
    }

    private fun bitPattern(n: Long) {

        var mask = 1L shl 63
        var count = 0
        while (mask != 0L) {
            if (count % 4 == 0)
                print(" ")

            if (mask and n == 0L)

                print("0")
            else
                print("1")


            count++
            mask = mask.ushr(1)


        }
        println()
    }

    constructor(genotype: Long) : this() {
        this.genotype = genotype
    }

    override fun flipBitAt(position: Int) {
        bitPattern(this.genotype)
        var mask: Long = 0L.inv() shl (getLength() - position) shr position
        this.genotype = (this.plus(getSegment(position, position + 1))).genotype as Long
        bitPattern(this.genotype)
    }
}

