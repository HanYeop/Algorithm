// [백준] 1904. 01타일 (Kotlin)

import java.util.*

lateinit var dp : Array<Int>

fun main() = with(Scanner(System.`in`)){
    val n = nextInt()
    dp = Array(n+1){0}

    for(i in 0 .. n){
        find(i)
    }

    println(dp[n])
}

// 피보나치
fun find(n: Int){
    when(n){
        0-> dp[0] = 1
        1-> dp[1] = 1
        else-> {
            dp[n] = (dp[n-2] + dp[n-1]) % 15746
        }
    }
}
