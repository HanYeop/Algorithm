// [백준] 1446. 지름길 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader

data class Node(val des: Int, val value: Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,d) = readLine().split(" ").map { it.toInt() }
    val size = d + 1
    val road = Array(size) { arrayListOf<Node>() }
    val dist = Array(size) { 0 }

    // 운전 거리, 지름길 초기화
    for(i in 0 until size){
        road[i] = arrayListOf()
        dist[i] = i
    }

    // 지름길 입력
    repeat(n){
        val (start,des,value) = readLine().split(" ").map { it.toInt() }

        // 범위보다 작은 입력값만 넣음
        if(start < size && des < size) {
            road[start].add(Node(des, value))
        }
    }

    for(i in 0 until size - 1){
        // 더 짧은 거리가 있다면 갱신
        if(dist[i + 1] > dist[i] + 1){
            dist[i + 1] = dist[i] + 1
        }

        // 현재 위치에서 시작하는 지름길 탐색
        for(j in road[i]) {
            // 지름길로 가는 비용이 더 짧다면 갱신
            if (dist[j.des] > (dist[i] + j.value)) {
                dist[j.des] = (dist[i] + j.value)
            }
        }
    }

    println(dist[d])
}
