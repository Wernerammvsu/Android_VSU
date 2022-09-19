import java.util.*

    fun main(args: Array<String>){
        val a = VectorK(0.0, 0.0, 0.0)
        val b = VectorK(4.0, 2.0, -2.0)
        val N = 4
        println("Длина вектора а: " + a.lenVectorK())
        println("Скалярное произведение вектора а на b: " + a.scalarMultiplyK(b))
        println("Векторное произведение вектора а на b: " + a.vectorMultiplyK(b))
        println("Угол между векторами а и b: " + a.angleK(b))
        println("Сумма векторов а и b: " + a.sumK(b))
        println("Разность векторов а и b: " + a.differenceK(b))
        println("Массив векторов " + Arrays.toString(VectorK.createRandomVectorsK(N)))
    }
    

