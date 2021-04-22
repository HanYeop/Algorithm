import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var arr = ArrayList<Long>()
    var num : Long
    var tmp : Int

    for (i in 1 .. 1023){
        num = 0
        tmp = i
        for(j in 9 downTo 0){
            if(tmp % 2 == 1) num = 10 * num + j
            tmp /= 2
        }
        arr.add(num)
    }

    arr.sort()

    var n = readLine().toInt()

    if(n>1022) println("-1")
    else    println(arr[n])
}
