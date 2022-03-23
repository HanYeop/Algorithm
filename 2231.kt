// [백준] 2231. 분해합 (Kotlin)

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    var tmp = n
    var len = 1
    while(tmp / 10 != 0){
        tmp /= 10
        len++
    }

    var index = n - (len * 9)
    while(true){
        var sum = index
        val cur = index.toString()

        for(i in cur){
            sum += (i - '0')
        }

        if(index > n){
            println(0)
            break
        }

        if(sum == n){
            println(index)
            break
        }

        index++
    }
}
