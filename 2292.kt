// [백준] 2292. 벌집 (Kotlin)

fun main() = with(System.`in`.bufferedReader()){
    var count = 1
    var max = 1
    val n = readLine().toInt()

    while(true){
        if (n<= max){
            println(count)
            break
        }

        max += 6 * count
        count++
    }
}
