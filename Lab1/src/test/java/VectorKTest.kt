import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class VectorKTest {
    private val firstVectorK: VectorK = VectorK(1.0, 2.1, 2.0);
    private val secondVectorK: VectorK = VectorK(4.0, 6.0, 0.1);
    private val delta = 0.01;

    @Test
    fun lenVectorK() {
        assertEquals(3.068, firstVectorK.lenVectorK(),delta)
    }

    @Test
    fun scalarMultiplyK() {
        assertEquals(16.8, firstVectorK.scalarMultiplyK(secondVectorK), delta)
    }

    @Test
    fun vectorMultiplyK() {
        assertEquals(VectorK(-11.79, 7.9, -2.4), firstVectorK.vectorMultiplyK(secondVectorK))
    }

    @Test
    fun angleK() {
        assertEquals(40.58, firstVectorK.angleK(secondVectorK), delta)
    }

    @Test
    fun sumK() {
        assertEquals(VectorK(5.0, 8.1, 2.1), firstVectorK.sumK(secondVectorK))
    }

    @Test
    fun differenceK() {
        assertEquals(VectorK(-3.0 , -3.9 , 1.9), firstVectorK.differenceK(secondVectorK))
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 7, 8, 9, 10, 0])
    fun createRandomVectors(expectedVectorsCount: Int) {
        val actualVectorsCount = VectorK.createRandomVectorsK(expectedVectorsCount).size
        Assertions.assertEquals(expectedVectorsCount, actualVectorsCount)
    }
}