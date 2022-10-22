// [백준] 25304. 영수증 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    
    var x = readLine().toInt()
    val n = readLine().toInt()

    for(i in 0 until n){
        val str = StringTokenizer(readLine())

        x -= (str.nextToken().toInt() * str.nextToken().toInt())
    }

    if(x == 0) println("Yes")
    else println("No")
}


