// [백준] 9095. 1, 2, 3 더하기 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val t = readLine().toInt()

    val dp = Array (11) { 0 }
    dp[1] = 1 // 1
    dp[2] = 2 // (1 + 1) , (2)
    dp[3] = 4 // (1 + 1 + 1), (1 + 2), (2 + 1), (3)

    for(i in 4 until 11){
        dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]
    }

    for(test in 0 until t){
        val n = readLine().toInt()
        println(dp[n])
    }
}
