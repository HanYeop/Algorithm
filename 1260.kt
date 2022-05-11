// [백준] 1260. DFS와 BFS (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0 // 정점의 개수
var m = 0 // 간선의 개수
var v = 0 // 탐색을 시작할 정점의 번호

lateinit var adj : Array<Array<Int>> // 인접 행렬
lateinit var visit : Array<Int> // 방문 여부

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    // 정점, 간선, 번호
    val st = readLine().split(" ").map { it.toInt() }
    n = st[0]
    m = st[1]
    v = st[2]

    adj = Array(n + 1) { Array (n + 1) { 0 } }
    visit = Array(n + 1) { 0 }

    // 입력
    for(i in 0 until m){
        val (x,y) = readLine().split(" ").map { it.toInt() }
        adj[x][y] = 1
        adj[y][x] = 1
    }

    dfs(v)
    println()
    bfs(v)
}

fun dfs(x: Int){
    print("$x ")
    visit[x] = 1

    for(i in 1 .. n){
        if(visit[i] == 1 || adj[x][i] == 0){
            continue
        }
        dfs(i);
    }
}

fun bfs(x: Int){
    val q: Queue<Int> = LinkedList()
    q.offer(x)
    visit[x] = 0

    while (q.isNotEmpty()){
        val cur = q.poll()
        print("$cur ")

        // DFS에서 방문처리를 1로 했으므로 여기선 0으로
        for(i in 1 .. n){
            if(visit[i] == 0 || adj[cur][i] == 0){
                continue
            }
            q.offer(i)
            visit[i] = 0
        }
    }
}
