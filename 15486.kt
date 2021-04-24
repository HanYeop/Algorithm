import kotlin.math.*

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    // 기간 [i][0] , 금액 [i][1]로 저장
    val arr = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    // 그 기간에 도착했을때 얻을 수 있는 최대 금액
    val dp = IntArray(n + 1)


    for (i in arr.indices) {
        val nx = i + arr[i][0]
        // 전에 것과 비교해서 금액 더 많이 받을 수 있는 것 선택 (현재 오히려 적게 받는다면 선택할 필요 없으므로)
        if (i > 0) dp[i] = max(dp[i], dp[i-1])
        // 범위를 초과한다면 스킵
        if (nx > n) continue
        // 그 기간에 도착했을 때 이미 저장된 금액과 새로 탐색한 일정 비교
        dp[nx] = max(dp[nx], dp[i] + arr[i][1])
    }

    println(max(dp[n], dp[n-1]))
}
