// [백준] 1213. 팰린드롬 만들기 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val str = readLine()
    var result = Array(str.length) {' '}
    var center = ' '
    val list = Array(26) {0}
    val strList = arrayListOf<Char>()
    var curStart = 0
    var curEnd = str.length - 1

    for(i in 0 until 26){
        strList.add('A' + i)
    }
    // 문자열 개수
    for(i in str){
        list[i - 'A'] += 1
    }

    for(i in list.indices){
        // 짝이 있는 수를 양 옆에 배치함
        while(list[i] - 2 >= 0){
            result[curStart++] = strList[i]
            result[curEnd--] = strList[i]
            list[i] -= 2
        }
        // 짝이 없는 수 (1개)
        if(list[i] == 1){
            // 길이가 짝수거나 이미 중간에 들어갈 문자가 있을 때
            if(center != ' ' || str.length % 2 == 0){
                println("I'm Sorry Hansoo")
                return@with
            }
            center = strList[i]
        }
    }

    if(str.length % 2 == 1){
        result[str.length / 2] = center
    }

    var sum = ""
    for(i in result){
        sum += i
    }

    println(sum)
}


