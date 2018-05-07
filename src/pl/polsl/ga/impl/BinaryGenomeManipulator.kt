package pl.polsl.ga.impl

import pl.polsl.ga.general.GenomeManipulator

/**
 * The genotype is of type Long so the maximum Bit count is 64 bits
 */
class BinaryGenomeManipulator() : GenomeManipulator<Long>() {
    override fun plus(genome1: Long, genome2: Long): Long {
        return genome1 or genome2
    }

    override fun getLength(): Int {
        return 64
    }

    override fun getSegment(genome: Long, start: Int, end: Int): Long {
        // Mask is used to get only the interesting segment and zeros where needed
        // Example: start = 2, end = 10
        // Mask: 00111111110000000000000...
        var mask: Long = -1L ushr (end - start)
        mask = mask.inv()
        mask = mask ushr start

//        bitPattern(mask)

        return genome and mask
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

    override fun flipBitAt(genome: Long, position: Int): Long {
        var mask: Long = getSegment(genome, position, position + 1)
        return genome and mask
    }
}

