import kotlin.math.sqrt

// ============================================================
// ЗАДАНИЕ 1. Сумма первой и последней цифры числа
// ============================================================
fun task1() {
    println("=== Задание 1. Сумма первой и последней цифры ===")
    print("Введите целое положительное число: ")
    val input = readln()

    // Способ 1: через строки
    val firstChar = input.first()
    val lastChar = input.last()
    val sumStr = firstChar.digitToInt() + lastChar.digitToInt()
    println("Способ 1 (строки): сумма = $sumStr")

    // Способ 2: через арифметику
    val number = input.toInt()
    val lastDigit = number % 10
    var temp = number
    while (temp >= 10) {
        temp /= 10
    }
    val firstDigit = temp
    println("Способ 2 (арифметика): сумма = ${firstDigit + lastDigit}")
}

// ============================================================
// ЗАДАНИЕ 2. Ввод чисел до 0, подсчёт количества, суммы, среднего
// ============================================================
fun task2() {
    println("\n=== Задание 2. Статистика введённых чисел ===")
    var count = 0
    var sum = 0.0
    while (true) {
        print("Введите число (0 для завершения): ")
        val num = readln().toDouble()
        if (num == 0.0) break
        count++
        sum += num
    }
    val average = if (count > 0) sum / count else 0.0
    println("Количество введённых чисел: $count")
    println("Общая сумма: $sum")
    println("Среднее арифметическое: $average")
}

// ============================================================
// ЗАДАНИЕ 3. Игра "Угадай число"
// ============================================================
fun task3() {
    println("\n=== Задание 3. Угадай число ===")
    val a = (0..10).random()
    println("Программа загадала число от 0 до 10. Попробуйте угадать!")
    while (true) {
        print("Ваш вариант: ")
        val b = readln().toInt()
        when {
            b > a -> println("Много")
            b < a -> println("Мало")
            else -> {
                println("Угадал")
                break
            }
        }
    }
}

// ============================================================
// ЗАДАНИЕ 4. Вывод n простых чисел
// ============================================================
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) return false
    }
    return true
}

fun task4() {
    println("\n=== Задание 4. Простые числа ===")
    print("Введите количество простых чисел n: ")
    val n = readln().toInt()
    var count = 0
    var num = 2
    while (count < n) {
        if (isPrime(num)) {
            count++
            println("$count-ое число: $num")
        }
        num++
    }
}

// ============================================================
// ЗАДАНИЕ 5. Элементы массива, большие соседей
// ============================================================
fun task5() {
    println("\n=== Задание 5. Элементы больше соседей ===")
    val arr = intArrayOf(1, 5, 3, 8, 2, 9, 4, 7, 6)
    println("Массив: ${arr.joinToString()}")

    print("Элементы, которые больше соседей: ")
    for (i in 1 until arr.size - 1) {
        if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
            print("${arr[i]} ")
        }
    }
    println()
}

// ============================================================
// ЗАДАНИЕ 6. Произведение, min, max массива разными способами
// ============================================================
fun task6() {
    println("\n=== Задание 6. Произведение, min и max ===")
    val arr = intArrayOf(2, 5, 3, 8, 1, 4)
    println("Массив: ${arr.joinToString()}")

    // Цикл for
    var productFor = 1L
    var minFor = arr[0]
    var maxFor = arr[0]
    for (x in arr) {
        productFor *= x
        if (x < minFor) minFor = x
        if (x > maxFor) maxFor = x
    }
    println("for:      произведение=$productFor, min=$minFor, max=$maxFor")

    // Цикл while
    var productWhile = 1L
    var minWhile = arr[0]
    var maxWhile = arr[0]
    var i = 0
    while (i < arr.size) {
        val x = arr[i]
        productWhile *= x
        if (x < minWhile) minWhile = x
        if (x > maxWhile) maxWhile = x
        i++
    }
    println("while:    произведение=$productWhile, min=$minWhile, max=$maxWhile")

    // forEach
    var productForEach = 1L
    arr.forEach { productForEach *= it }
    println("forEach:  произведение=$productForEach")

    // reduce
    val productReduce = arr.fold(1L) { acc, x -> acc * x }
    println("reduce:   произведение=$productReduce")

    // min() max()
    println("min()=${arr.min()}, max()=${arr.max()}")
}

// ============================================================
// ЗАДАНИЕ 7. Квадратное уравнение
// ============================================================
fun sqr(n: Double): Double = n * n

fun discriminant(a: Double, b: Double, c: Double): Double = sqr(b) - 4 * a * c

fun rootsNumber(a: Double, b: Double, c: Double): Int {
    val d = discriminant(a, b, c)
    return when {
        d > 0 -> 2
        d == 0.0 -> 1
        else -> 0
    }
}

fun quadraticRoot(a: Double, b: Double, c: Double) {
    val d = discriminant(a, b, c)
    when (rootsNumber(a, b, c)) {
        2 -> {
            val x1 = (-b + sqrt(d)) / (2 * a)
            val x2 = (-b - sqrt(d)) / (2 * a)
            println("Два корня: x1 = $x1, x2 = $x2")
        }
        1 -> {
            val x = -b / (2 * a)
            println("Один корень: x = $x")
        }
        else -> println("Корней нет (D < 0)")
    }
}

fun task7() {
    println("\n=== Задание 7. Квадратное уравнение ===")
    print("Введите a, b, c через пробел: ")
    val parts = readln().split(" ")
    val a = parts[0].toDouble()
    val b = parts[1].toDouble()
    val c = parts[2].toDouble()
    if (a == 0.0) {
        println("Это не квадратное уравнение (a = 0)")
        return
    }
    quadraticRoot(a, b, c)
}

// ============================================================
// ЗАДАНИЕ 8. Класс для работы с массивом
// ============================================================
class ArrayProcessor(private val arr: IntArray) {

    fun sumPositive(): Int {
        var sum = 0
        for (x in arr) if (x > 0) sum += x
        return sum
    }

    fun product(): Long {
        var p = 1L
        for (x in arr) p *= x
        return p
    }

    fun average(): Double {
        if (arr.isEmpty()) return 0.0
        var sum = 0.0
        for (x in arr) sum += x
        return sum / arr.size
    }
}

fun task8() {
    println("\n=== Задание 8. Класс ArrayProcessor ===")
    val processor = ArrayProcessor(intArrayOf(3, -5, 7, 2, -1, 4))
    println("Сумма положительных: ${processor.sumPositive()}")
    println("Произведение элементов: ${processor.product()}")
    println("Среднее арифметическое: ${processor.average()}")
}

// ============================================================
// ЗАДАНИЕ 9. Класс Vector
// ============================================================
class Vector(val x: Double, val y: Double, val z: Double) {

    fun length(): Double = sqrt(x * x + y * y + z * z)

    fun dot(other: Vector): Double = x * other.x + y * other.y + z * other.z

    infix fun scalar(other: Vector): Double = this.dot(other)

    operator fun times(other: Vector): Double = this.dot(other)

    override fun toString(): String = "Vector($x, $y, $z)"
}

fun dotProduct(v1: Vector, v2: Vector): Double =
    v1.x * v2.x + v1.y * v2.y + v1.z * v2.z

fun task9() {
    println("\n=== Задание 9. Класс Vector ===")
    val v1 = Vector(1.0, 2.0, 3.0)
    val v2 = Vector(3.0, 2.0, 1.0)

    println("Длина v1: ${v1.length()}")
    println("Скалярное произведение (метод): ${v1.dot(v2)}")
    println("Инфиксная запись: ${v1 scalar v2}")
    println("Оператор *: ${v1 * v2}")
    println("Внешняя функция: ${dotProduct(v1, v2)}")
}

// ============================================================
// ЗАДАНИЕ 10. Наследование Vehicle
// ============================================================
open class Vehicle(
    open val name: String = "Транспортное средство",
    open val speed: Int = 0
) {
    open fun start() {
        println("$name начал движение со скоростью $speed км/ч")
    }

    open fun stop() {
        println("$name остановился")
    }
}

class Boat : Vehicle("Лодка", 30) {
    override fun start() {
        println("$name начала движение со скоростью $speed км/ч")
    }
    override fun stop() {
        println("$name бросила якорь")
    }
}

class Airplane : Vehicle("Самолёт", 900) {
    override fun start() {
        println("$name начал движение со скоростью $speed км/ч")
    }
    override fun stop() {
        println("$name совершил посадку")
    }
}

class Tank : Vehicle("Танк", 50) {
    override fun start() {
        println("$name начал движение со скоростью $speed км/ч")
    }
    override fun stop() {
        println("$name остановился")
    }
}

fun task10() {
    println("\n=== Задание 10. Наследование Vehicle ===")
    val vehicles: List<Vehicle> = listOf(Boat(), Airplane(), Tank())
    for (v in vehicles) {
        v.start()
        v.stop()
        println()
    }
}

// ============================================================
// ГЛАВНАЯ ФУНКЦИЯ — последовательный запуск всех заданий
// ============================================================
fun main() {
    task1()
    task2()
    task3()
    task4()
    task5()
    task6()
    task7()
    task8()
    task9()
    task10()

    println("\n=== Все задания выполнены ===")
}