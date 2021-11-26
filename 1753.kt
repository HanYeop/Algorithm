// [백준] 1753. 최단경로 (Kotlin)

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

const val INF = 1000000

data class Node(val index: Int, val dist: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int = dist-other.dist
}


fun main() = with(System.`in`.bufferedReader()){
    var st = StringTokenizer(readLine()) // 문자열 쪼개기

    val v = st.nextToken().toInt()// 정점의 개수
    val e = st.nextToken().toInt() // 간선의 개수
    val k = readLine().toInt() // 시작 정점 번호
    val dis = Array(v+1){INF} // 정점 최소경로
    val sb = StringBuilder()

    // 각 정점에 대하여 인접리스트 생성
    val adj = ArrayList<ArrayList<Node>>()
    for(i in 0 .. v){
        adj.add(ArrayList())
    }

    // 간선 입력받기
    for(i in 0 until e){
        st = StringTokenizer(readLine())

        val index = st.nextToken().toInt()
        val des = st.nextToken().toInt()
        val w = st.nextToken().toInt()

        adj[index].add(Node(des,w)) // index 에서 des 로 가는 간선의 가중치 w
    }

    // 다익스트라 알고리즘
    fun dijkstra(srt: Int){
        val queue = PriorityQueue<Node>()

        dis[srt] = 0 // 시작점 자신은 0
        queue.add(Node(srt,0)) // 시작점 넣기

        while(queue.isNotEmpty()){
            val curIndex = queue.peek().index  // 현재 노드 인덱스
            val curDist = queue.peek().dist  // 현재 노드까지의 거리
            queue.poll()

            if (dis[curIndex] < curDist) continue // 가중치가 더 큰 경로 탐색 X

            // 인접리스트 탐색
            for (i in 0 until adj[curIndex].size) {
                val nextIndex = adj[curIndex][i].index
                val nextDist = curDist + adj[curIndex][i].dist

                if (nextDist < dis[nextIndex]) {
                    dis[nextIndex] = nextDist
                    queue.add(Node(nextIndex, nextDist))
                }
            }
        }
    }

    dijkstra(k)

    for(i in 1 .. v){
        if(dis[i] == INF) sb.append("INF\n")
        else sb.append("${dis[i]}\n")
    }

    println(sb)
}
