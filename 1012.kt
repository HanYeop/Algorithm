import java.util.*

var m = 0 // 가로길이
var n = 0 // 세로길이
var k = 0 // 배추 개수
var count = 0 // 마리 수

// 상하좌우
val dx = listOf(-1,1,0,0)
val dy = listOf(0,0,-1,1)

lateinit var arr : Array<Array<Int>>

fun main() = with(Scanner(System.`in`)){

    val t = nextInt() // 테스트 케이스 개수

    for(i in 0 until t){
        count = 0
        m = nextInt()
        n = nextInt()
        k = nextInt()
        arr = Array(m){Array<Int>(n){0} }

        for(j in 0 until k){
            arr[nextInt()][nextInt()] = 1
        }

        // 다 방문할때까지 반복
        for(x in 0 until m){
            for(y in 0 until n){
                // 떨어져있는곳 방문할때마다 +1
                if(arr[x][y] == 1) {
                    find(x,y)
                    count++
                }
            }
        }
        println(count)
    }
}

fun find(x : Int, y : Int){
    for(i in 0 until 4){
        val nx = x + dx[i]
        val ny = y + dy[i]

        // 상하좌우를 탐색하여 인접한 곳 방문 체크
        if(nx >= 0 && ny >= 0 && nx < m && ny < n){
            if(arr[nx][ny] == 1){
                arr[nx][ny] = 0
                find(nx,ny)
            }
        }
    }
}


