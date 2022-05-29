// [백준] 1446. 지름길 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader

data class Node(val des: Int, val value: Int): Comparable<Node>{
    override fun compareTo(other: Node): Int {
        return this.value - other.value
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,d) = readLine().split(" ").map { it.toInt() }
    val size = d + 1
    val road = Array(size) { arrayListOf<Node>() }
    val dist = Array(size) { 0 }

    for(i in road.indices){
        road[i] = arrayListOf()
    }

    for(i in dist.indices){
        dist[i] = i
    }

    repeat(n){
        val (s,d,v) = readLine().split(" ").map { it.toInt() }
        road[s].add(Node(d,v))
    }

    for(i in 0 until size){
        for(j in road[i]) {
            if(j.des < size) {
                if (dist[j.des] >= (dist[i] + j.value)) {
                    dist[j.des] = (dist[i] + j.value)
                    for(q in j.des + 1 until size){
                        dist[q] = (dist[i] + j.value) + (q - j.des)
                    }
                }
            }
        }
    }

    println(dist[d])
}
