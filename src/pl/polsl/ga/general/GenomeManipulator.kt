package pl.polsl.ga.general

/**
 * Class responsible for manipulation of a genome
 */
abstract class GenomeManipulator<T> {

    /**
     * @return the length of the genome
     */
    abstract fun getLength(): Int

    /**
     * @return the segment of the genome from start (inclusive) to the end (exclusive)
     */
    abstract fun getSegment(genome: T, start: Int, end: Int): T

    /**
     * @return the genome with the bit at position flipped - 0->1, 1->0
     */
    abstract fun flipBitAt(genome: T, position: Int): T

    /**
     * @return bitwise or on the genome1 and genome2
     */
    abstract fun plus(genome1: T, genome2: T): T
}