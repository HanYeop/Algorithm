// [백준] 11657. 타임머신 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var dist: Array<Long>
lateinit var adj: ArrayList<Node>
var n = 0
var m = 0
var cycle = false

data class Node(val start: Int, val des: Int, val value: Long)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()
    dist = Array(n + 1){Long.MAX_VALUE} // 최솟값 저장
    adj = arrayListOf() // 간선 정보 저장

    // 간선 정보 입력
    for(i in 0 until m){
        val st = StringTokenizer(readLine())
        val start = st.nextToken().toInt()
        val des = st.nextToken().toInt()
        val value = st.nextToken().toLong()

        adj.add(Node(start,des,value))
    }

    bellmanFord(1)

    // 사이클이 존재하면
    if (cycle){
        println("-1")
    }
    // 사이클이 존재하지 않으면
    else{
        for(i in 2 .. n){
            // 경로가 없다면
            if(dist[i] == Long.MAX_VALUE) {
                dist[i] = -1
            }
            println(dist[i])
        }
    }
}

fun bellmanFord(srt: Int){

    dist[srt] = 0 // 시작점 자신은 0

    for(i in 1 .. n){
        for(cur in adj){
            val curStart = cur.start
            val curDes = cur.des
            val nextValue = dist[curStart] + cur.value

            // 현재값이 초기화 된 상태이고 최솟값을 갱신할 수 있으면
            if(dist[curStart] != Long.MAX_VALUE && dist[curDes] > nextValue){
                dist[curDes] = nextValue

                // n번째 반복 때 최솟값이 갱신되었다면
               if(i == n){
                    cycle = true
                }
            }
        }
    }
}

