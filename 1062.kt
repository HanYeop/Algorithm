// [백준] 1062. 가르침 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashSet
import kotlin.math.max

var n = 0
var k = 0
var list = arrayListOf<String>()
var max = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val st = StringTokenizer(readLine())

    n = st.nextToken().toInt()
    k = st.nextToken().toInt()

    // 단어 입력
    for(i in 0 until n){
        list.add(readLine())
    }

    // 최소 5개 이상이어야 함
    if(k < 5) {
        println(0)
        return
    }
    // 26개면 모든 단어 가능
    else if (k == 26){
        println(n)
        return
    }

    combi(hashSetOf(0,2,8,13,19), 0, 0)
    println(max)
}

// 조합
fun combi(set: HashSet<Int>, index: Int, count: Int){
    if(count == k - 5){
        solve(set)
        return
    }

    for(i in index until 26){
        if (!set.contains(i)) {
            set.add(i)
            combi(set, i + 1, count + 1)
            set.remove(i)
        }
    }
}

fun solve(set: HashSet<Int>){
    val alpha = Array(26) {false}
    var result = 0

    loop@
    for(str in list){
        var count = 0
        for(char in str){
            val index = (char - 'a') // 현재 문자 (0 = a, 1 = b ..)

            // 만들 수 없는 단어일 경우 다음 단어 탐색
            if(!set.contains(index)){
                continue@loop
            }

            if(!alpha[index]){
                alpha[index] = true
                count++
            }

            // 만들 수 없는 단어일 경우 다음 단어 탐색
            if(count > k){
                continue@loop
            }
        }
        result++ // 만들 수 있는 단어 개수
    }

    // 최댓값
    max = max(max,result)
}
