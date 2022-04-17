// [백준] 1149. RGB거리 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()

    // 입력받은 비용
    val r = arrayListOf<Int>()
    val g = arrayListOf<Int>()
    val b = arrayListOf<Int>()

    // 최소 비용
    val dpR = Array(n){ 0 }
    val dpG = Array(n){ 0 }
    val dpB = Array(n){ 0 }

    // 입력
    repeat(n){
        val str = StringTokenizer(readLine())
        r.add(str.nextToken().toInt())
        g.add(str.nextToken().toInt())
        b.add(str.nextToken().toInt())
    }

    // 처음 값은 항상 최대값
    dpR[0] = r[0]
    dpG[0] = g[0]
    dpB[0] = b[0]

    for(i in 1 until n){
        dpR[i] = min(dpG[i - 1], dpB[i - 1]) + r[i]
        dpG[i] = min(dpR[i - 1], dpB[i - 1]) + g[i]
        dpB[i] = min(dpR[i - 1], dpG[i - 1]) + b[i]
    }

    val result = min(dpR[n - 1],min(dpG[n - 1], dpB[n - 1]))

    println(result)
}
