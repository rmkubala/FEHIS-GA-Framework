package pl.polsl.ga.general

abstract class Genome<T> {

    abstract var genotype: T

    abstract fun getLength(): Int

    abstract fun getSegment(start: Int, end: Int): Genome<*>

    abstract fun flipBitAt(position: Int)

    abstract fun plus(other: Genome<*>): Genome<*>
}