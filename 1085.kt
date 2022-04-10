// [백준] 1085. 직사각형에서 탈출 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (x,y,w,h) = readLine().split(" ").map { it.toInt() }

    val disX = w - x
    val disY = h - y

    println(min(disX,min(disY,min(y,x))))
}
