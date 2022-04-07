// [백준] 1929. 소수 구하기 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (m,n) = readLine().split(" ").map { it.toInt() }
    val prime = Array(n + 1) {true}
    val sb = StringBuilder()

    if(n < 2){
        return
    }

    // 0과 1은 소수가 아님
    prime[0] = false
    prime[1] = false

    for(i in 2 .. n){
        if(prime[i]){
            for(j in 2 * i .. n step i){
                prime[j] = false
            }
        }
    }

    // 소수 출력
    for(i in m .. n){
        if(prime[i]){
            sb.append("$i\n")
        }
    }

    println(sb)
}
