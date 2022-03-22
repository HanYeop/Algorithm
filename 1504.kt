// [백준] 1504. 특정한 최단 경로 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

lateinit var dist: Array<Int>
lateinit var list: Array<ArrayList<Pair>>
const val INF = 200000001

data class Pair(val des: Int, val value: Int) : Comparable<Pair>{
    override fun compareTo(other: Pair): Int = value - other.value
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    var res1 = 0
    var res2 = 0

    val (n,e) = readLine().split(" ").map { it.toInt() }
    list = Array(n + 1) { arrayListOf()}
    dist = Array(n + 1) {INF}

    // 인접리스트 생성
    for(i in 0 until e){
        val (start, des, value) = readLine().split(" ").map {it.toInt()}
        list[start].add(Pair(des,value))
        list[des].add(Pair(start,value))
    }

    // 거쳐야 하는 점
    val (one, two) = readLine().split(" ").map { it.toInt() }

    // 시작점 -> v1 -> v2 -> n
    res1 += dijkstra(1, one)
    res1 += dijkstra(one, two)
    res1 += dijkstra(two, n)

    // 시작점 -> v2 -> v1 -> n
    res2 += dijkstra(1, two)
    res2 += dijkstra(two, one)
    res2 += dijkstra(one, n)

    // 둘 중 더 작은 경로
    var result = min(res1,res2)

    // 경로를 찾지 못한 경우
    if(result >= INF) {
        result = -1
    }
    println(result)
}

// 다익스트라
fun dijkstra(srt: Int, e: Int): Int{
    // 초기화
    Arrays.fill(dist, INF)

    val queue = PriorityQueue<Pair>()

    dist[srt] = 0 // 시작점 자신은 0
    queue.add(Pair(srt,0)) // 시작점 넣기

    while(queue.isNotEmpty()){
        val curIndex = queue.peek().des  // 현재 노드 인덱스
        val curValue = queue.peek().value  // 현재 노드까지의 거리
        queue.poll()

        if (dist[curIndex] < curValue) continue // 가중치가 더 큰 경로 탐색 X

        if(curIndex == e){
            break
        }
        // 인접리스트 탐색
        for (i in list[curIndex]) {
            val nextDes = i.des
            val nextValue = curValue + i.value

            // 최솟값 갱신
            if (nextValue < dist[nextDes]) {
                dist[nextDes] = nextValue
                queue.add(Pair(nextDes, nextValue))
            }
        }
    }

    return dist[e]
}
