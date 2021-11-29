// [백준] 1436. 영화감독 숌 (Kotlin)

fun main() = with(System.`in`.bufferedReader()){
    var n = readLine().toInt()
    var number = 665

    // 666보다 큰 모든 수에 대하여 666 포함여부 n번째 수까지 탐색
    while(n!=0){
        number++
        if(number.toString().contains("666")){
            n--
        }
    }

    println(number)
}
