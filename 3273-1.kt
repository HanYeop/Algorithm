// [백준] 3273. 두 수의 합 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val n = readLine().toInt()
    val list = readLine().split(" ").map { i -> i.toInt() }.toMutableList()
    val x= readLine().toInt()
    var count = 0

    var start = 0 // 앞 쪽 포인터
    var end = n - 1 // 뒤 쪽 포인터

    list.sort() // 정렬

    // 더 이상 탐색하지 못할 때 까지
    while(start < end){
        val sum = list[start] + list[end]

        // 쌍을 찾으면 카운트
        if(sum == x){
            count++
        }

        // x보다 작으면 sum 을 늘려야하므로 start++
        if(sum <= x){
            start++
        }
        
        // x보다 크다면 sum 을 줄여야하므로 end--
        else{
            end--
        }
    }

    println(count)
}


