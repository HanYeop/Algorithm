// [백준] 2206. 벽 부수고 이동하기 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Pair(var row: Int, var col: Int, var distance: Int, var flag: Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    // 상하좌우
    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)

    val (n,m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { Array(m) { 0 } }

    // 방문 배열 (false = 안 부수고 방문한 곳, true = 부순 이후 방문한 곳)
    val visit = Array(n) { Array(m) { Array(2) {false} } } 
    var queue = LinkedList<Pair>()

    // 입력
    for(i in 0 until n){
        val str = readLine()
        for(j in 0 until m){
            map[i][j] = str[j] - '0'
        }
    }

    queue.offer(Pair(0,0,1,0))
    visit[0][0][0] = true
    visit[0][0][1] = true

    // bfs
    while(queue.isNotEmpty()){
        val cur = queue.poll()

        if(cur.row == n - 1 && cur.col == m - 1){
            println(cur.distance)
            return
        }

        for(i in 0 until 4){
            val nextRow = cur.row + dx[i]
            val nextCol = cur.col + dy[i]
            val flag = cur.flag
            val distance = cur.distance

            // 범위 벗어나면
            if(nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m){
                continue
            }

            // 벽이라면
            if(map[nextRow][nextCol] == 1){
                // 탐색하면서 아직 부순적이 없고, 부순 경로에서 방문한 적이 없던 곳이라면 탐색
                if(flag == 0 && !visit[nextRow][nextCol][1]){
                    visit[nextRow][nextCol][1] = true // 부순 경로에서 방문 처리
                    queue.offer(Pair(nextRow, nextCol, distance + 1, 1))
                }
                continue
            }

            // 이미 방문했다면
            if(visit[nextRow][nextCol][0] && flag == 0){
                continue
            }

            // 이미 방문했다면
            if(visit[nextRow][nextCol][1] && flag == 1){
                continue
            }

            visit[nextRow][nextCol][flag] = true
            queue.offer(Pair(nextRow,nextCol,distance + 1, flag))
        }
    }
    println(-1)
}


