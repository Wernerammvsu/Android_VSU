import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Vector a = new Vector(0, 0, 0);
        Vector b = new Vector(4, 2, -2);
        int N = 4;

        System.out.println("Длина вектора а: " + a.lenVector());
        System.out.println("Скалярное произведение вектора а на b: " + a.scalarMultiply(b));
        System.out.println("Векторное произведение вектора а на b: " + a.vectorMultiply(b));
        System.out.println("Угол между векторами а и b: " + a.angle(b));
        System.out.println("Сумма векторов а и b: " + a.sum(b));
        System.out.println("Разность векторов а и b: " + a.difference(b));
        System.out.println("Массив векторов " + Arrays.toString(Vector.createRandomVectors(N)));
    }
}
