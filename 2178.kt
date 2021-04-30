import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    val tmp = readLine().split(" ").map { it.toInt() }
    var que = LinkedList<Pair<Int,Int>>()
    var n = tmp[0]
    var m = tmp[1]
    var count = 0

    // 상하좌우
    val dx = listOf(-1,1,0,0)
    val dy = listOf(0,0,-1,1)

    // 가장자리 띄어줌
    val map = Array(n+2){Array(m+2){0} }
    val visit = Array(n+2){Array(m+2){0} }

    for(i in 1 .. n){
        val line = readLine().toString()
        for(j in 0 until m){
            map[i][j+1] = line[j]-'0'
        }
    }

    que.add(Pair(1,1))

    while (que.isNotEmpty()){
        count++ // 레벨 카운트
        for(q in 0 until que.size) {
            val pop = que.poll()
            val x = pop.first
            val y = pop.second

            // 목표 도달시 리턴
            if (x == n && y == m) return println(count)

            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (map[nx][ny] == 1 && visit[nx][ny] == 0) {
                    que.add(Pair(nx, ny))
                    visit[nx][ny] = 1
                }
            }
        }
    }
}

