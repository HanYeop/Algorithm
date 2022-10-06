// [백준] 20413. MVP 다이아몬드 (Easy) (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val (s, g, p, d) = readLine().split(" ").map { it.toInt() }

    val str = readLine()
    var sum = 0
    var prev = 0

    for(i in str.indices){
        var cur = 0
        when(str[i]){
            'B' ->{
                cur = s - prev - 1
            }
            'S' ->{
                cur = g - prev - 1
            }
            'G' -> {
                cur = p - prev - 1
            }
            'P' -> {
                cur = d - prev - 1
            }
            'D' -> {
                cur = d
            }
        }
        sum += cur
        prev = cur
    }

    println(sum)
}


