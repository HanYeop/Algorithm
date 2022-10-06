// [백준] 17086. 아기 상어 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { Array(m) { 0 } }
    val shark = arrayListOf<Pair<Int, Int>>()
    var max = -1
    val dx = listOf(-1,-1,0,1,1,1,0,-1)
    val dy = listOf(0,1,1,1,0,-1,-1,-1)

    fun bfs(position: Pair<Int, Int>){
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val visit = Array(n) { Array(m) { false } }

        queue.offer(position)
        var count = 1 // 깊이

        while(queue.isNotEmpty()){
            var size = queue.size

            while(size > 0){
                val curPoll = queue.poll()
                val x = curPoll.first
                val y = curPoll.second
                size--

                for(i in 0 until 8){
                    val curX = x + dx[i]
                    val curY = y + dy[i]

                    if(curX >= 0 && curY >= 0 && curX < n && curY < m){
                        if(map[curX][curY] >= 0 && !visit[curX][curY]){
                            queue.offer(Pair(curX, curY))

                            if(map[curX][curY] >= 1){
                                map[curX][curY] =  min(map[curX][curY],count)
                            }else{
                                map[curX][curY] = count
                            }
                            visit[curX][curY] = true
                        }
                    }
                }
            }
            count++
        }
    }

    var sum = 1
    for(i in 0 until n){
        val st = StringTokenizer(readLine())
        for(j in 0 until m){
            map[i][j] = st.nextToken().toInt() * -1

            // 상어 위치
            if(map[i][j] < 0){
                shark.add(Pair(i,j))
                sum += map[i][j]
            }
        }
    }
    for(i in shark){
        bfs(i)
    }

    for(i in 0 until n){
        for(j in 0 until m){
            max = max(max, map[i][j])
        }
    }
    println(max)
}


