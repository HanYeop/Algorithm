// [백준] 2869. 달팽이는 올라가고 싶다 (Kotlin)
import java.util.*
import kotlin.math.ceil

fun main() = with(System.`in`.bufferedReader()){
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toLong()
    val b = st.nextToken().toLong()
    val v = st.nextToken().toLong()
    val move = a - b

    var count = 1
    var cur = v - a
    val tmp = ceil(cur.toDouble()/move.toDouble()).toLong()
    println(count + tmp)
}
