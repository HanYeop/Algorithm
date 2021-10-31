import java.util.*
import kotlin.math.min

var min = 10000
var arr = Array(2000){Array(2000){0} }

fun main() = with(Scanner(System.`in`)){
    var n = nextInt()
    find(n,0,0,0)

    // 정확하게 만들 수 있는 경우가 하나도 없음
    if(min == 10000) min = -1

    println(min)
}

fun find(n: Int,x: Int,y: Int, count: Int){
    arr[x][y] = 1

    // 정확하게 배달이 끝났을 때 최소 횟수 체크
    if(n==0){
        min = min(min,count)
        return
    }

    // 정확하게 만들 수 없음
    if(n<0){
        return
    }

    // 이미 한 계산이라면 또 할필요 없음
    if(arr[x+1][y] != 1) find(n-3,x+1,y,count+1)
    if(arr[x][y+1] != 1) find(n-5,x,y+1,count+1)
}
