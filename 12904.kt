// [백준] 12904. A와 B (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val s = readLine()
    var t = readLine()

    // 역으로 탐색
    while (true){
        // 바꿀 수 있으면 1 출력
        if(t == s){
            println(1)
            return@with
        }

        // 더 이상 탐색할 수 없을 때
        if(t.length == 1){
            break
        }

        val last = t.length - 1

        // 마지막 문자가 A면 A뺌
        if(t[last] == 'A'){
            t = t.substring(0,last)
        }
        // 마지막 문자가 B면 B빼고 그 역순
        else if(t[last] == 'B'){
            t = (t.substring(0,last)).reversed()
        }
    }

    // 바꿀 수 없으면 0 출력
    println(0)
}

