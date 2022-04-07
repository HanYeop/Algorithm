// [백준] 4948. 베르트랑 공준 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val len = (123456 * 2)
    val prime = Array(len + 1) { true }
    prime[0] = false
    prime[1] = false

    for(i in 2 .. len){
        if(prime[i]){
            for(j in (2 * i) .. len step i){
                prime[j] = false
            }
        }
    }

    while(true) {
        val n = readLine().toInt()

        // 마지막 입력
        if(n == 0){
            return
        }

        var count = 0
        for(i in (n + 1) .. (2 * n)){
            if(prime[i]){
                count++
            }
        }

        println(count)
    }
}
