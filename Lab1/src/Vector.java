public class Vector {
    double x;
    double y;
    double z;

    Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double lenVector(){
        return Math.pow(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2), 0.5);
    }

    public double scalarMultiply(Vector anotherVector){
        return this.x * anotherVector.x + this.y * anotherVector.y + this.z * anotherVector.z;
    }

    public Vector vectorMultiply(Vector anotherVector){
        double x1 = this.y * anotherVector.z - this.z * anotherVector.y;
        double y1 = this.z * anotherVector.x - this.x * anotherVector.z;
        double z1 = this.x * anotherVector.y - this.y * anotherVector.x;
        return new Vector(x1, y1, z1);
    }

    public double angle(Vector anotherVector){
        double denominator = this.lenVector() * anotherVector.lenVector();
        double result = 0;
        if (denominator != 0) {
            double cos = scalarMultiply(anotherVector) / (this.lenVector() * anotherVector.lenVector());
            result = Math.acos(cos) / Math.PI * 180;
        }
        return result;
    }

    public Vector sum(Vector anotherVector){
        return new Vector(this.x + anotherVector.x, this.y + anotherVector.y, this.z + anotherVector.z);
    }

    public Vector difference(Vector anotherVector){
        return new Vector(this.x - anotherVector.x, this.y - anotherVector.y, this.z - anotherVector.z);
    }

    public static Vector[] createRandomVectors(int N){
        Vector[] randomVectors = new Vector[N];
        for(int i = 0; i < N; i++) {
            randomVectors[i] = new Vector(Math.ceil(Math.random() * 10), Math.ceil(Math.random() * 10), Math.ceil(Math.random() * 10));
        }
        return randomVectors;
    }

    public String toString(){
        return "[" + this.x + ", " + this.y + ", " + this.z + "]";
    }
}
