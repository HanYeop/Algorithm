
var arr = arrayOf(arrayOf<Char>())
var white = 0
var blue = 0
var whitesum = 0
var bluesum = 0

// 상하좌우
val dx = listOf(-1,1,0,0)
val dy = listOf(0,0,-1,1)

fun main() = with(System.`in`.bufferedReader()){

    // 가로, 세로크기
    var (n,m) = readLine().split(" ").map { it.toInt() }

    // 병사 배열 입력
    arr = Array(m){ Array<Char>(n){' '} }
    for(i in 0 until m){
        val tmp = readLine().toString()
        for(j in 0 until n){
            arr[i][j] = tmp[j]
        }
    }

    // 방문 여부
    val visit = Array(m){Array(n){0} }

    // dfs
    fun dfs(x : Int, y : Int){
        visit[x][y] = 1 // 방문표시

        if(arr[x][y] == 'W') white++
        else if(arr[x][y] == 'B') blue++

        for(i in 0 until 4){
            val nx = x+dx[i]
            val ny = y+dy[i]

            // 상하좌우 탐색
            if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                if(arr[nx][ny] == arr[x][y] && visit[nx][ny] == 0){
                    dfs(nx,ny)
                }
            }
        }
    }

    // 방문하지 않은 곳만 방문
    for(i in 0 until m){
        for(j in 0 until n){
            if(visit[i][j] == 0){
                dfs(i,j)
                // dfs 가 끝날때마다 병사 계산
                whitesum += white*white
                bluesum += blue*blue
                white = 0
                blue = 0
            }
        }
    }

    println(whitesum)
    println(bluesum)
}

