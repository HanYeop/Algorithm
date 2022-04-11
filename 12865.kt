// [백준] 12865. 평범한 배낭 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,k) = readLine().split(" ").map{ it.toInt() }
    val arr = Array(n) { IntArray (2) }
    val dp = Array(k + 1){ 0 }

    for(i in 0 until n){
        val st = StringTokenizer(readLine())
        arr[i][0] = st.nextToken().toInt()
        arr[i][1] = st.nextToken().toInt()
    }

    for(i in 0 until n){
        for(j in k downTo arr[i][0]){
            dp[j] = max(dp[j], dp[j - arr[i][0]] + arr[i][1])
        }
    }

    println(dp[k])
}
