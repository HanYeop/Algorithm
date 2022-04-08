// [백준] 9020. 골드바흐의 추측 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val t = readLine().toInt()
    val size = 10000 + 1
    val prime = Array(size) { true }
    val primeList = arrayListOf<Int>()
    val sb = StringBuilder()
    prime[0] = false
    prime[1] = false

    // 에라토스테네스의 체
    for(i in 2 until size){
        for(j in i * 2 until size step i){
            if(prime[i]){
                prime[j] = false
            }
        }
    }

    // 소수 리스트 생성
    for(i in 2 until size){
        if(prime[i]){
            primeList.add(i)
        }
    }

    repeat(t){
        val n = readLine().toInt()

        // 두 수의 차가 가장 작은 n/2 부터 시작
        for(i in (n / 2) downTo 1){
            if(prime[n - i] && prime[i]){
                sb.append("$i ${n - i} \n")
                break
            }
        }
    }

    println(sb)
}
