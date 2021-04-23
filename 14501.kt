import java.util.*
import kotlin.math.max

var maximum = 0
var sum = 0
var arr = arrayListOf<Pair<Int,Int>>()
var n = 0

fun main() = with(Scanner(System.`in`)) {
    n = nextInt()

    // 입력받은 t와 p 쌍으로 저장
    for(i in 0 until n){
        arr.add(Pair(nextInt(),nextInt()))
    }
    
    // 가능한 모든 경우 탐색
    for(i in 0 until n){
        find(i,arr[i].first)
    }

    println(maximum)
}

fun find(index : Int, x : Int){
     // 퇴사하는 날까지 딱 맞춰 일한경우
     if(index+x == n){
         sum+= arr[index].second
         maximum = max(maximum,sum)
         sum = 0
     }
    // 퇴사하는 날 넘어가는 일 일 때
    else if(index+x > n){
         maximum = max(maximum,sum)
         sum = 0
     }
    
    // 퇴사하는 날 전에 할 수 있는 일
    else {
         sum += arr[index].second
         var tmp = sum
         for(i in index+x until n) {
             // 이후로 할 수 있는 일의 경우 다 따져봄
             sum = tmp
             find(i,arr[i].first)
         }
     }
}
