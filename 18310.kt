// [백준] 18310. 안테나 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val house = Array(n + 1) {0}

    val str = readLine().split(" ")
    for(i in 1 .. n){
        house[i] = str[i - 1].toInt()
    }
    house.sort()

    // 홀수
    if(n % 2 == 1){
        println(house[n / 2 + 1])
    }
    // 짝수
    else{
        println(house[n / 2])
    }
}
