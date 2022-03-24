// [백준] 2661. 좋은수열 (Kotlin)

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

var n = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    n = readLine().toInt()

    solve("1")
    solve("2")
    solve("3")
}

fun solve(str: String){
    val len = str.length

    if(!check(str)){
        return
    }

    // 가장 작은 수열
    if(len == n){
        println(str)
        exitProcess(0)
    }

    // 다음에 같은 수가 나오면 안됨
    if(str[len - 1] != '1'){
        solve(str + '1')
    }
    if(str[len - 1] != '2'){
        solve(str + '2')
    }
    if(str[len - 1] != '3'){
        solve(str + '3')
    }
}

// 좋은 수열인지 판별
fun check(str: String) : Boolean{
    var count = (str.length + 1) / 2

    var start = 0
    var end = count

    // 홀수면 시작위치 조정
    if(str.length % 2 != 0){
        start = 1
    }

    // 수열 반반으로 나눠서 검사
    for(i in start until count){
        if(str.substring(start,end) == str.substring(end, str.length)){
            return false
        }
        start += 2
        end += 1
    }
    return true
}
