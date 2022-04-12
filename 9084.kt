// [백준] 9084. 동전 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val t = readLine().toInt()

    repeat(t){
        val n = readLine().toInt()
        val st = StringTokenizer(readLine())
        val list = arrayListOf<Int>()

        // 아이템 입력
        for(i in 0 until n){
            list.add(st.nextToken().toInt())
        }

        val price = readLine().toInt()
        val dp = Array(price + 1){0}
        dp[0] = 1

        for(i in list){
            for(j in i .. price){
                dp[j] += dp[j - i]
            }
        }

        println(dp[price])
    }
}
