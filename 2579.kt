import java.util.*
import kotlin.math.max

fun main() = with(Scanner(System.`in`)){
    val n = nextInt()
    val a = Array(n+1){0}
    val dp = Array(n+1){0}

    for(i in 1 until a.size){
        a[i] = nextInt()
    }

    for(i in 1 until dp.size){
        when (i) {
            0 -> dp[i] = 0
            1 -> dp[i] = a[1]
            2 -> dp[i] = a[1] + a[2]
            /**
             * 1. 1번 연속으로 밟는 경우
             * 2. 2번 연속으로 밟는 경우
             */
            else ->{
                dp[i] = max((a[i] + dp[i-2]),(a[i]+a[i-1]+dp[i-3]))
            }
        }
    }

    println(dp[n])
}
