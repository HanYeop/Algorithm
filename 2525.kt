// [백준] 2525. 오븐 시계 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (a,b) = readLine().split(" ").map { i -> i.toInt() }
    val c = readLine().toInt()

    var time = a * 60 + b + c

    val hour = (time / 60) % 24
    val min = time % 60

    println("$hour $min")
}
