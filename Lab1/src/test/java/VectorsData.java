public class VectorsData {
    public final Vector firstVector;
    public final Vector secondVector;
    public final double firstVectorLength;
    public final double dotProduct;
    public final Vector vectorProduct;
    public final double vectorAngle;
    public final Vector vectorSum;
    public final Vector vectorDifference;

    public VectorsData(Vector firstVector, Vector secondVector, double firstVectorLength, double dotProduct,
                       Vector vectorProduct, double vectorAngle, Vector vectorSum, Vector vectorDifference) {
        this.firstVector = firstVector;
        this.secondVector = secondVector;
        this.firstVectorLength = firstVectorLength;
        this.dotProduct = dotProduct;
        this.vectorProduct = vectorProduct;
        this.vectorAngle = vectorAngle;
        this.vectorSum = vectorSum;
        this.vectorDifference = vectorDifference;
    }
}
