// [백준] 1339. 단어 수학 (Kotlin)
import java.util.*
import kotlin.math.pow

fun main() = with(Scanner(System.`in`)){
    val n = nextInt()
    var map = mutableMapOf<Char,Int>()
    nextLine()

    for(i in 0 until n){
        val a = nextLine()
        var len = a.length-1

        a.forEach {
            // 자리수 표현
            val tmp = 10f.pow(len)
            // 이미 알파벳이 존재하면 더해줌
            if(map.contains(it)){
                map[it] = map[it]!!.plus(tmp.toInt())
            }
            // 없다면 새로 추가
            else{
                map[it] = tmp.toInt()
            }
            len--
        }
    }

    // 값이 큰 순으로 정렬
    val list  = map.toList().sortedByDescending { it.second }

    var num = 9
    var sum = 0 // 결과값

    // 값이 큰 순으로 알파벳에 큰 숫자 배정
    for(i in 0 until map.size){
        sum += list[i].second * num--
    }

    println(sum)
}
