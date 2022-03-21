// [백준] 2581. 소수 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val m = readLine().toInt()
    val n = readLine().toInt()
    var min = 0
    var sum = 0

    // true => 소수
    val arr = Array(n + 1) {true}

    // 0과 1은 소수 X
    arr[0] = false
    arr[1] = false

    // 소수의 배수는 전부 소수가 아님
    for(i in 2 .. n){
        if(arr[i]){
            for(j in (2 * i) .. n step i){
                arr[j] = false
            }
        }
    }

    // 범위 내의 소수 합
    for(i in m .. n){
        if(arr[i]){
            if(min == 0){
                min = i
            }
            sum += i
        }
    }

    // 소수가 없을 때
    if(min == 0){
        println(-1)
    }
    else {
        println(sum)
        println(min)
    }
}


