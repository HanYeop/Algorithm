import java.util.*

val arr = arrayListOf<Int>()
var n = 0
val dp = Array(101){Array(21){0L} } // [x]번째 까지의 수를 사용하여 [y]를 만드는 경우의 수

fun main() = with(Scanner(System.`in`)){
    n = nextInt()
    nextLine()

    for(i in 0 until n){
        arr.add(next().toInt())
    }

    // 맨 처음 원소 초기화
    dp[0][arr[0]] = 1

    // 두번째 수 부터 결과 전 수까지 탐색
    for (i in 1 until n-1) {
        for (j in 0..20) {
            // 탐색하지 않은 경우에만
            if (dp[i-1][j] != 0L) {
                // 조건 : 중간에 나오는 수가 모두 0 이상 20 이하이어야 한다.
                if (j + arr[i] <= 20) dp[i][j + arr[i]] += dp[i-1][j]
                if (j - arr[i] >= 0) dp[i][j - arr[i]] += dp[i-1][j]
            }
        }
    }
    println(dp[n-2][arr[n-1]])
}
