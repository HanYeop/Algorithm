// [백준] 14226. 이모티콘 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var s = 0
const val MAX_SIZE = 1000 + 1
lateinit var visit : Array<Array<Boolean>>

// 길이, 클립보드
data class Emoji(var len: Int, var clip: Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    s = readLine().toInt()
    visit = Array(MAX_SIZE) { Array(MAX_SIZE) { false } }
    bfs()
}

fun bfs(){
    val q : Queue<Emoji> = LinkedList()
    q.offer(Emoji(1, 0))
    visit[1][0] = true

    var time = 0
    while(q.isNotEmpty()){
        val size = q.size

        // 레벨 체크
        for(i in 0 until size){
            val cur = q.poll()

            if(cur.len == s){
                println(time)
                return
            }

            // 정답의 범위
            if(cur.len in 1 .. 1000){

                // 클립보드에 현재 이모티콘 복사
                if(!visit[cur.len][cur.len]){
                    visit[cur.len][cur.len] = true;
                    q.offer(Emoji(cur.len, cur.len))
                }

                // 현재 복사되어 있는 이모티콘 붙여넣기
                if(cur.len + cur.clip < MAX_SIZE){
                    if(!visit[cur.len + cur.clip][cur.clip]){
                        visit[cur.len + cur.clip][cur.clip] = true
                        q.offer(Emoji(cur.len + cur.clip, cur.clip))
                    }
                }

                // 이모티콘 1개 삭제
                if(!visit[cur.len - 1][cur.clip]){
                    visit[cur.len - 1][cur.clip] = true
                    q.offer(Emoji(cur.len - 1, cur.clip))
                }
            }
        }
        time++
    }
}

