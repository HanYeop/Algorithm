// [백준] 3078. 좋은 친구 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt() // 학생 수
    val k = st.nextToken().toInt() // 등수 차이
    val queue = Array<Queue<Int>>(21) { LinkedList<Int>() } // 길이별로 큐 생성
    var count = 0L // 좋은 친구쌍 수

    // 정보 입력
    for(i in 0 until n){
        val len = readLine().length

        while(queue[len].isNotEmpty()){
            // 범위를 벗어나는 값 poll
            if(i - queue[len].peek()!! > k){
                queue[len].poll()
            }
            else{
                break
            }
        }
        count += queue[len].size // 남은 값(범위에 속한 값)이 친구쌍 수이므로 더해줌
        queue[len].offer(i) // 현재길이 큐에 현재 인덱스 삽입
    }
    println(count)
}
