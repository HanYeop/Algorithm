// [백준] 15649. N과 M (1) (Kotlin)

import java.lang.StringBuilder
import java.util.*

fun main() = with(Scanner(System.`in`)){
    val n = nextInt()
    val m = nextInt()
    val visit = Array(n+1){false} // 방문 여부
    val arr = Array(m){0} // 수열 결과
    val sb = StringBuilder()

    fun find(len : Int){
        if(len == m) {
            // 문자열 만들기
            arr.forEach {
                sb.append(it).append(' ')
            }
            sb.append('\n')
            return
        }

        for(i in 1 .. n){
            // 포함되지 않았다면
            if(!visit[i]){
                // 방문 처리
                visit[i] = true
                arr[len] = i
                find(len+1)
                // 다른 탐색을 위해 false 처리
                visit[i] = false
            }
        }
    }

    find(0)
    println(sb) // 한번에 출력
}
