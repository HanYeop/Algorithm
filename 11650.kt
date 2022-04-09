// [백준] 11650. 좌표 정렬하기 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

data class Pair(val x: Int, val y: Int) : Comparable<Pair>{
    override fun compareTo(other: Pair): Int {
        if(this.x == other.x){
            return this.y - other.y
        }
        return this.x - other.x
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val list = arrayListOf<Pair>()
    val sb = StringBuilder()

    repeat(n){
        val (x,y) = readLine().split(" ").map{ it.toInt() }
        list.add(Pair(x,y))
    }

    list.sort()

    for(i in list){
        sb.append("${i.x} ${i.y}\n")
    }

    print(sb)
}
