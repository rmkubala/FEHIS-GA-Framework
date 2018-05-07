package pl.polsl.ga.general

abstract class GenomeManipulator<T> {

    abstract fun getLength(): Int

    abstract fun getSegment(genome: T, start: Int, end: Int): T

    abstract fun flipBitAt(genome: T, position: Int): T

    abstract fun plus(genome1: T, genome2: T): T
}