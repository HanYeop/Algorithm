// [백준] 11653. 소인수분해 (Kotlin)

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var n = readLine().toInt()

    if(n == 1){
        return
    }

    var index = 2
    while(n >= index){
        if(n % index == 0){
            n /= index
            println(index)
        }
        else{
            index++
        }
    }
}
