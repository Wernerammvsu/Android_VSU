import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.Arrays;
import java.util.stream.Stream;

public class VectorTest {
    private static final VectorsData[] vectorsDataArray = new VectorsData[] {
            new VectorsData(new Vector(0.0, 0.0, 0.0), new Vector(0.0, 0.0, 0.0),0,0, new Vector(0.0, 0.0, 0.0),0,new Vector(0.0, 0.0, 0.0), new Vector(0.0, 0.0, 0.0)),
            new VectorsData(new Vector(1.0, 2.1, 2.0), new Vector(4.0, 6.0, 0.1),3.068,16.8,new Vector(-11.79, 7.9, -2.4),40.58,new Vector(5, 8.1, 2.1), new Vector(-3 , -3.9 , 1.9)),
            new VectorsData(new Vector(0.1, 0.2, 2.1), new Vector(0.2, 4.0, 6.0),2.112,13.42,new Vector(-7.2, -0.18, 0.36),28.25,new Vector(0.3, 4.2, 8.1), new Vector(-0.1, -3.8, -3.9)),
            new VectorsData(new Vector(4.0, 2.0, 2.6), new Vector(0.0, 8.3, 1.4),5.173,20.24,new Vector(-18.78, -5.6, 33.2),62.3,new Vector(4, 10.3, 4), new Vector(4, -6.3, 1.2)),
            new VectorsData(new Vector(7.5, 5.0, 8.0), new Vector(1.0, 0.0, 0.6),12.052,12.3,new Vector(3, 3.5, -5),28.938,new Vector(8.5, 5, 8.6), new Vector(6.5, 5, 7.4)),
            new VectorsData(new Vector(1.2, 0.6, 2.6), new Vector(7.0, 2.5, 0.7),2.926,11.72,new Vector(-6.08, 17.36, -1.2),57.55,new Vector(8.2, 3.1, 3.3), new Vector(-5.8, -1.9, 1.9)),
            new VectorsData(new Vector(0.6, 2.1, 2.0), new Vector(0.2, 9.7, 1.0),2.961,22.49,new Vector(-17.3, -0.2, 5.4),38.86,new Vector(0.8, 11.8, 3), new Vector(0.4, -7.6, 1)),
            new VectorsData(new Vector(6.0, 0.0, 6.5), new Vector(6.5, 0.8, 0.3),8.846,40.95,new Vector(-5.2, 40.45, 4.8),45.079,new Vector(12.5, 0.8, 6.8), new Vector(-0.5, -0.8, 6.2))
    };

    private static Stream<Arguments> provideVectorsWithLengths() {
        return Stream.of(Arrays.stream(vectorsDataArray).map(data ->
                Arguments.of(
                    data.firstVector, data.firstVectorLength
                )
        ).toArray(Arguments[]::new));
    }
    private static Stream<Arguments> provideVectorsWithMultiply() {
        return Stream.of(Arrays.stream(vectorsDataArray).map(data ->
                Arguments.of(
                        data.firstVector, data.secondVector, data.dotProduct
                )
        ).toArray(Arguments[]::new));
    }

    private static Stream<Arguments> provideVectorsWithVectorMultiply() {
        return Stream.of(Arrays.stream(vectorsDataArray).map(data ->
                Arguments.of(
                        data.firstVector, data.secondVector, data.vectorProduct
                )
        ).toArray(Arguments[]::new));
    }

    private static Stream<Arguments> provideVectorsAngle() {
        return Stream.of(Arrays.stream(vectorsDataArray).map(data ->
                Arguments.of(
                        data.firstVector, data.secondVector, data.vectorAngle
                )
        ).toArray(Arguments[]::new));
    }

    private static Stream<Arguments> provideVectorsSum() {
        return Stream.of(Arrays.stream(vectorsDataArray).map(data ->
                Arguments.of(
                        data.firstVector, data.secondVector, data.vectorSum
                )
        ).toArray(Arguments[]::new));
    }

    private static Stream<Arguments> provideVectorsDifference() {
        return Stream.of(Arrays.stream(vectorsDataArray).map(data ->
                Arguments.of(
                        data.firstVector, data.secondVector, data.vectorDifference
                )
        ).toArray(Arguments[]::new));
    }

    public static double delta = 0.1;

    @ParameterizedTest
    @MethodSource("provideVectorsWithLengths")
    public void lenVector(@NotNull Vector vector, double expectedLength) {
        double actualLength = vector.lenVector();
        Assertions.assertEquals(expectedLength, actualLength, delta);
    }

    @ParameterizedTest
    @MethodSource("provideVectorsWithMultiply")
    public void scalarMultiply(Vector vector1, Vector vector2, double expectedMultiply) {
        double actualMultiply = vector1.scalarMultiply(vector2);
        Assertions.assertEquals(expectedMultiply, actualMultiply, delta);
    }

    @ParameterizedTest
    @MethodSource("provideVectorsWithVectorMultiply")
    public void vectorMultiply(@NotNull Vector vector1, Vector vector2, Vector expectedVectorMultiply) {
        Vector actualVectorMultiply = vector1.vectorMultiply(vector2);
        Assertions.assertEquals(expectedVectorMultiply, actualVectorMultiply);
    }

    @ParameterizedTest
    @MethodSource("provideVectorsAngle")
    public void angle(Vector vector1, Vector vector2, double expectedVectorAngle) {
        double actualAngle = vector1.angle(vector2);
        Assertions.assertEquals(expectedVectorAngle, actualAngle, delta);
    }

    @ParameterizedTest
    @MethodSource("provideVectorsSum")
    public void sum(Vector vector1, Vector vector2, Vector expectedVectorSum) {
        Vector actualSum = vector1.sum(vector2);
        Assertions.assertEquals(expectedVectorSum, actualSum);
    }

    @ParameterizedTest
    @MethodSource("provideVectorsDifference")
    public void difference(Vector vector1, Vector vector2, Vector expectedVectorDifference) {
        Vector actualDifference = vector1.difference(vector2);
        Assertions.assertEquals(expectedVectorDifference, actualDifference);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 7, 8, 9, 10, 0})
    public void createRandomVectors(int expectedVectorsCount) {
        int actualVectorsCount = Vector.createRandomVectors(expectedVectorsCount).length;
        Assertions.assertEquals(expectedVectorsCount, actualVectorsCount);
    }
}