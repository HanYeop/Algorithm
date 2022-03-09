// [백준] 10026. 적록색약 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

var n = 0
lateinit var arr : Array<Array<Int>>
lateinit var arrC : Array<Array<Int>>
lateinit var visit : Array<Array<Boolean>>
lateinit var visitC: Array<Array<Boolean>>

// 상하좌우
val dx = arrayOf(-1,1,0,0)
val dy = arrayOf(0,0,-1,1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    n = readLine().toInt()
    arr = Array(n) {Array(n) {0}}
    arrC = Array(n) {Array(n) {0}}
    visit = Array(n) {Array(n) {false}}
    visitC = Array(n) {Array(n) {false}}

    var count = 0
    var countC = 0

    // 그림 정보 입력
    for(i in 0 until n){
        val str = readLine()
        for(j in str.indices){
            when(str[j]){
                'R' -> arr[i][j] = 1
                'G' -> arr[i][j] = 2
                'B' -> arr[i][j] = 4
            }
        }
    }

    // dfs
    for(i in 0 until n){
        for(j in 0 until n){
            if(!visit[i][j]){
                dfs(i,j,false)
                count++
            }

            if(!visitC[i][j]){
                dfs(i,j,true)
                countC++
            }
        }
    }

    println("$count $countC")
}

// color : false (색약)
fun dfs(x: Int, y: Int, color: Boolean){
    if(!color){
        visit[x][y] = true
    }
    else{
        visitC[x][y] = true
    }

    for(i in 0 until 4){
        val nextX = x + dx[i]
        val nextY = y + dy[i]

        // null check
        if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n){
            continue
        }

        // 상하좌우 탐색
        if(!color) {
            if (!visit[nextX][nextY] && (arr[x][y] == arr[nextX][nextY])) {
                dfs(nextX, nextY, false)
            }
        }
        else{
            val tmp = abs(arr[x][y] - arr[nextX][nextY])
            if (!visitC[nextX][nextY] && tmp <= 1) {
                dfs(nextX, nextY, true)
            }
        }
    }
}
