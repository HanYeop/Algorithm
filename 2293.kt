// [백준] 2293. 동전 1 (Kotlin)

import java.util.*

fun main() = with(Scanner(System.`in`)){
    val n = nextInt()
    val k = nextInt()
    val dp = Array(10001){0}
    val coin = Array(n){0}
    dp[0] = 1

    for(i in 0 until n){
        coin[i] = nextInt()
    }

    for(i in 0 until n){
        for(j in coin[i] .. k){
            dp[j] += dp[j - coin[i]]
        }
    }

    println(dp[k])
}
