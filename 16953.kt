import kotlin.math.min

var a : Long= 0L
var b : Long= 0L
var minimum : Long = 1000000000L

fun main() = with(System.`in`.bufferedReader()){
    val (a,b) = readLine().split(" ").map { it.toLong() }

    find(a,b,0)

    // 못찾았다면 -1 리턴
    if(minimum == 1000000000L){
        println("-1")
    }
    else println(minimum+1)

}

fun find(a : Long, b : Long, count : Long){

    // 찾았을 때 몇번 수행하였는지 체크하여 최소값 비교
    if(a==b) {
        minimum = min(minimum,count)
        return
    }

    // 더 커졌다면 연산할 필요 x
    else if(a>b){
        return
    }

    find(a*2,b,count+1)
    find((a.toString()+"1").toLong(),b,count+1)
}
