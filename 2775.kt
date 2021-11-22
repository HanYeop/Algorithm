// [백준] 2775. 부녀회장이 될테야 (Kotlin)

import java.util.*

fun main() = with(Scanner(System.`in`)){
    val t = nextInt()
    val dp = Array(15){Array(15){0} }

    for(i in 0 until 15){
        for(j in 0 until 15){
            if(i == 0 || j == 0) dp[i][j] = j+1
            else dp[i][j] = dp[i-1][j] + dp[i][j-1]
        }
    }

    for(i in 0 until t){
        val k = nextInt()
        val n = nextInt()
        println(dp[k][n-1])
    }
}
