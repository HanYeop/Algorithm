// [백준] 10844. 쉬운 계단 수 (Kotlin)

import java.util.*

fun main() = with(Scanner(System.`in`)){
    val n = nextInt()
    // dp[i][j] => 길이가 i일때 마지막 숫자가 j인 수의 갯수
    val dp = Array(n+1){ Array(10){0} }

    // 0
    dp[1][0] = 0

    // 1 ~ 9
    for(j in 1 until 10){
        dp[1][j] = 1
    }

    for(i in 2 until n+1){
        for(j in 0 until 10){
            when(j){
                0 -> dp[i][j] = dp[i-1][1] // 0은 1 뒤에만 추가할 수 있음
                9 -> dp[i][j] = dp[i-1][8] // 9는 8 뒤에만 추가할 수 있음
                else -> dp[i][j] = (dp[i-1][j+1] + dp[i-1][j-1]) % 1000000000
            }
        }
    }

    var sum = 0L
    dp[n].forEach { sum += it }
    sum %= 1000000000
    println(sum)
}
