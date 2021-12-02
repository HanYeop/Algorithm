// [백준] 7576. 토마토 (Kotlin)
import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt() // 세로 칸 수
    val m = st.nextToken().toInt() // 가로 칸 수
    val tomato = Array(m+2){Array(n+2){-1} } // 토마토 창고
    var count = -1 // 걸리는 날짜
    var queue = arrayListOf<Pair<Int,Int>>() // 다음날 익을 토마토 저장

    // 입력
    for(i in 1 until m+1){
        st = StringTokenizer(readLine())
        for(j in 1 until n+1){
            tomato[i][j] = st.nextToken().toInt()
        }
    }

    // 하나씩 확인
    for(i in 1 until m+1){
        for(j in 1 until n+1){
            // 익은 토마토라면 큐에 추가
            if(tomato[i][j] == 1){
                queue.add(Pair(i,j))
            }
        }
    }

    // 하루가 지나면 상하좌우 토마토 익음, 더이상 익을게 없을때 까지 반복
    while(queue.isNotEmpty()) {
        count++ // 다음날
        val tmp = arrayListOf<Pair<Int,Int>>() // 지금 익은 토마토 저장
        tmp.addAll(queue) // 지금 익은 토마토 불러옴(queue)
        queue = arrayListOf<Pair<Int,Int>>() // 다음날 익을 토마토 저장 위해 초기화

        // 상하좌우 다음날 익을 토마토 큐에 저장
        for(q in 0 until tmp.size){
            val i = tmp[q].first
            val j = tmp[q].second
            if (tomato[i][j - 1] == 0) {
                tomato[i][j - 1] = 1
                queue.add(Pair(i,j-1))
            }
            if (tomato[i][j + 1] == 0) {
                tomato[i][j + 1] = 1
                queue.add(Pair(i,j+1))
            }
            if (tomato[i - 1][j] == 0) {
                tomato[i - 1][j] = 1
                queue.add(Pair(i-1,j))
            }
            if (tomato[i + 1][j] == 0) {
                tomato[i + 1][j] = 1
                queue.add(Pair(i+1,j))
            }
        }
    }

    // 더이상 익을 수 있는 것이 없을 때, 익지 않은 토마토가 있다면
    for (i in 1 until m+1){
        for(j in 1 until n+1){
            if(tomato[i][j] == 0) {
                println(-1)
                return
            }
        }
    }

    println(count)

//    // 창고 확인
//    tomato.forEach { println(it.contentToString()) }
}
