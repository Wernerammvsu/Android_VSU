

import java.lang.Math.*
import kotlin.math.ceil
import kotlin.math.pow

class VectorK internal constructor(var x: Double, var y: Double, var z: Double) {
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

    override fun toString(): String {
        return "[$x, $y, $z]"
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