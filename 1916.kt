// [백준] 1916. 최소비용 구하기 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var dist: Array<Int>
lateinit var map: Array<ArrayList<Node>>

data class Node(val des: Int, val value: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int = value - other.value
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val m = readLine().toInt()
    dist = Array(n + 1){Int.MAX_VALUE}
    map = Array(n + 1) {arrayListOf()}

    // 그래프 생성
    for(i in 0 until m){
        val st = StringTokenizer(readLine())
        val start = st.nextToken().toInt()
        val des = st.nextToken().toInt()
        val value = st.nextToken().toInt()

        map[start].add(Node(des,value))
    }

    val st = StringTokenizer(readLine())
    val start = st.nextToken().toInt()
    val des = st.nextToken().toInt()

    dijkstra(start) // 시작점에서 탐색 시작
    println(dist[des]) // 목적지 최솟값 출력
}

fun dijkstra(srt: Int){
    val queue = PriorityQueue<Node>()

    dist[srt] = 0 // 시작점 자신은 0
    queue.add(Node(srt,0)) // 시작점 넣기

    while(queue.isNotEmpty()){
        val curDes = queue.peek().des  // 현재 노드 인덱스
        val curValue = queue.peek().value  // 현재 노드까지의 거리
        queue.poll()

        if (dist[curDes] < curValue) continue // 가중치가 더 큰 경로 탐색 X

        // 인접리스트 탐색
        for (i in map[curDes]) {
            val nextDes = i.des
            val nextValue = curValue + i.value

            // 최솟값 갱신
            if (nextValue < dist[nextDes]) {
                dist[nextDes] = nextValue
                queue.add(Node(nextDes, nextValue))
            }
        }
    }
}

