// [백준] 1018. 체스판 다시 칠하기 (Kotlin)

import java.util.*
import kotlin.math.min

fun main() = with(Scanner(System.`in`)){
    val n = nextInt()
    val m = nextInt()
    val dp :Array<Array<Char>> = Array(n){Array(m){'.'} }
    var min = 1000000 // 최솟값
    var curX = 0
    var curY = 0
    var countW = 0 // whiteChess 기준으로 다른 칸 갯수
    var countB = 0 // blackChess 기준으로 다른 칸 갯수

    // 맨 왼쪽 위 칸이 흰색
    val whiteChess = arrayOf(
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW"
    )

    // 맨 왼쪽 위 칸이 검은색
    val blackChess = arrayOf(
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB"
    )

    // 입력받기
    nextLine()
    for(i in 0 until n){
        val tmp = nextLine()
        for(j in 0 until m){
            dp[i][j] = tmp[j]
        }
    }


    while(true){
        // 더이상 자를 부분이 없는경우
        if(curX + 8  >  m && curY + 8 > n) break
        var x = 0
        var y = 0

        // 8*8 열로 자를 수 있을 때
        if( curX + 8  <=  m ){
            // 8*8 행으로 자를 수 있을 때
            if( curY + 8 <= n){
                for(i in curY until curY+8){
                    for(j in curX until curX+8){
                        if(whiteChess[x][y] != dp[i][j]) countW++
                        if(blackChess[x][y] != dp[i][j]) countB++
                        y++
                    }
                    y = 0
                    x++
                }
                val result = min(countW,countB)
                min = min(result,min)
                countW = 0
                countB = 0
                curX++
            }
            else{
                break
            }
        }
        // 8*8 의 열로 자를 수 없는 경우
        else{
            // 다음 행으로
            curX = 0
            curY++
        }
    }

    println(min)
}
