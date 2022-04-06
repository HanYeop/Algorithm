// [백준] 7562. 나이트의 이동 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Pair(val x: Int, val y: Int)

var l = 0
lateinit var cur : Pair
lateinit var des : Pair
lateinit var visit : Array<Array<Boolean>>
val dx = arrayListOf(-1,-2,-2,-1,1,2,2,1)
val dy = arrayListOf(-2,-1,1,2,2,1,-1,-2)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val test = readLine().toInt()

    repeat(test){
        l = readLine().toInt()
        val (x1,y1) = readLine().split(" ").map { it.toInt() }
        cur = Pair(x1,y1)
        val (x2,y2) = readLine().split(" ").map { it.toInt() }
        des = Pair(x2,y2)
        visit = Array(l){ Array(l){ false } }

        println(bfs())
    }
}

fun bfs() : Int{
    // 처음부터 시작점과 목적지가 같으면
    if(cur == des){
        return 0
    }
    val q : Queue<Pair> = LinkedList()
    q.offer(cur) // 시작점 삽입
    visit[cur.x][cur.y] = true

    var count = 1
    while(q.isNotEmpty()){
        val size = q.size
        for(i in 0 until size){
            val curPair = q.poll()

            for(i in 0 until 8){
                val curX = curPair.x + dx[i]
                val curY = curPair.y + dy[i]

                // 범위 벗어나면
                if(curX < 0 || curX >= l || curY < 0 || curY >= l){
                    continue
                }
                // 이미 방문한 위치라면
                if(visit[curX][curY]){
                    continue
                }
                // 목적지에 도달하면 리턴
                if(curX == des.x && curY == des.y){
                    return count
                }
                
                // 방문처리하고 큐에 삽입
                visit[curX][curY] = true
                q.offer(Pair(curX,curY))
            }
        }
        count++
    }

    return -1
}
