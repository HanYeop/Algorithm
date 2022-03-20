// [백준] 3273. 두 수의 합 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val n = readLine().toInt()
    val list = readLine().split(" ").map { i -> i.toInt() }.toHashSet()
    val x= readLine().toInt()
    var count = 0

    for(i in list){
        // 합해서 x를 만들 수 있는 다른 원소가 있으면
        if(list.contains(x - i)){
            count++
        }
    }

    // 쌍이므로 나누기 2
    println(count / 2)
}


