import java.lang.Math.*
import kotlin.math.ceil
import kotlin.math.pow

 data class VectorK internal constructor(var x: Double, var y: Double, var z: Double) {
    fun lenVectorK(): Double {
        return (x.pow(2.0) + y.pow(2.0) + z.pow(2.0)).pow(0.5)
    }

    fun scalarMultiplyK(anotherVector: VectorK): Double {
        return x * anotherVector.x + y * anotherVector.y + z * anotherVector.z
    }

    fun vectorMultiplyK(anotherVector: VectorK): VectorK {
        val x1 = y * anotherVector.z - z * anotherVector.y
        val y1 = z * anotherVector.x - x * anotherVector.z
        val z1 = x * anotherVector.y - y * anotherVector.x
        return VectorK(x1, y1, z1)
    }

    fun angleK(anotherVector: VectorK): Double {
        val denominator = lenVectorK() * anotherVector.lenVectorK()
        var result = 0.0
        if (denominator != 0.0) {
            val cos = scalarMultiplyK(anotherVector) / (lenVectorK() * anotherVector.lenVectorK())
            result = kotlin.math.acos(cos) / PI * 180
        }
        return result
    }

    fun sumK(anotherVector: VectorK): VectorK {
        return VectorK(x + anotherVector.x, y + anotherVector.y, z + anotherVector.z)
    }

    fun differenceK(anotherVector: VectorK): VectorK {
        return VectorK(x - anotherVector.x, y - anotherVector.y, z - anotherVector.z)
    }


    override fun equals(other: Any?): Boolean {
        if (other == null || other !is VectorK)
            return false
        val xRes: Double = kotlin.math.abs(x - other.x)
        val yRes: Double = kotlin.math.abs(y - other.y)
        val zRes: Double = kotlin.math.abs(z - other.z)
        val sumRes = xRes + yRes + zRes
        return sumRes <= 0.03
    }
    override fun hashCode(): Int {
        var hash = 5
        hash = 12 * hash + ceil(x).toInt()
        hash = 12 * hash + ceil(y).toInt()
        hash = 12 * hash + ceil(z).toInt()
        return hash
    }
    companion object {
        fun createRandomVectorsK(N: Int): Array<VectorK?> {
            val randomVectors = arrayOfNulls<VectorK>(N)
            for (i in 0 until N) {
                randomVectors[i] = VectorK(
                        ceil(random() * 10), ceil(random() * 10), ceil(
                        random() * 10
                )
                )
            }
            return randomVectors
        }
    }
}