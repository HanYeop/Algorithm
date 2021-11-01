import java.util.*
import kotlin.math.max

fun main() = with(Scanner(System.`in`)){
    val n = nextInt()
    val grape = Array(n+1){0}
    val dp = Array(n+1){0} // 최대값 저장

    // 헷갈리지 않기 위해 인덱스 1부터 시작
    grape[0] = 0

    // 포도주 잔 입력
    for(i in 1 until grape.size){
        grape[i] = nextInt()
    }

    for(i in dp.indices){
        when (i) {
            0 -> dp[i] = grape[0] // 포도주가 0개 ( 계산과정용 )
            1 -> dp[i] = grape[1] // 첫번째 포도주 마시기
            2 -> dp[i] = grape[1] + grape[2] // 두번째 포도주 마시기
            // 세번째 이상 포도주 마시기
            else -> {
                /**
                 * 1. 안마시는 경우
                 * 2. 1번 연속으로 마시는 경우
                 * 3. 2번 연속으로 마시는 경우
                 */
                dp[i] = max(max(dp[i-1], (grape[i] + dp[i-2])), (grape[i] + grape[i-1] + dp[i-3]))
            }
        }
    }

    println(dp[n])
}
