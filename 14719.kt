import java.util.*

lateinit var map : Array<IntArray>
var h = 0
var w = 0

fun main() = with(Scanner(System.`in`)){
    h = nextInt()
    w = nextInt()
    var sum = 0

    map = Array(w){IntArray(h){0} }

    // 오른쪽으로 눕힌 느낌으로
    for(i in 0 until w){
        val tmp = nextInt()
        for(j in 0 until tmp){
            map[i][j] = 1
        }
    }

    // 전체 탐색
    for(i in 0 until w){
        for(j in 0 until h){
            // 블럭이 없는 곳일 때
            if(map[i][j] == 0){
                // 위에가 막혀있나 탐색해봄
                if(Up(i-1,j)) {
                    // 아래가 막혀있나 탐색해봄
                    if(Down(i+1,j)) sum++
                }
            }
        }
    }

    println(sum)
}

fun Up(i : Int , j : Int) : Boolean{
    if(i >=0){
        return if(map[i][j] == 1) true
        else Up(i-1,j)
    }
    return false
}

fun Down(i : Int , j : Int) : Boolean{
    if(i < w){
        return if(map[i][j] == 1) true
        else Down(i+1,j)
    }
    return false
}
