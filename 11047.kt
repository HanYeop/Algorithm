// [백준] 11047. 동전 0 (Kotlin)

import java.util.*

var sum = 0

fun main() = with(Scanner(System.`in`)){
    val n = nextInt()
    var k = nextInt()

    val arr = Array(n){0}

    for(i in 0 until n){
        arr[i] = nextInt()
    }

    // 하행연산
    for(i in n-1 downTo 0){
        val tmp = k/arr[i]
        sum += tmp
        k -= tmp*arr[i]
    }

    println(sum)
}
