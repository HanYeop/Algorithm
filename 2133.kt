// [백준] 2133. 타일 채우기 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val dp = Array(n + 1){ 0 }
    dp[0] = 1

    for(i in 2 .. n step 2){
        dp[i] = dp[i - 2] * 3

        for(j in (i - 4) downTo 0 step 2){
            dp[i] += 2 * dp[j]
        }
    }

    println(dp[n])
}



