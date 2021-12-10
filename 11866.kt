// [백준] 11866. 요세푸스 문제 0 (Kotlin)
import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val queue : Queue<Int> = LinkedList()
    val sb = StringBuffer("<")

    for(i in 1 .. n){
        queue.add(i)
    }

    while(queue.isNotEmpty()){
        // 맨 앞의 원소를 맨 뒤로 보냄
        for(i in 0 until k-1){
            queue.offer(queue.poll())
        }

        // k번째 원소는 뺌
        if(queue.size == 1) sb.append("${queue.poll()}>")
        else sb.append("${queue.poll()}, ")
    }

    println(sb)
}
