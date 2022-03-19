// [백준] 2480. 주사위 세개 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (a,b,c) = readLine().split(" ").map { i -> i.toInt() }
    var result = 0

    if(a == b && b == c){
        result = 10000 + ( a * 1000 )
    }
    else if(a == b || a == c){
        result = 1000 + ( a * 100 )
    }
    else if(b == c){
        result = 1000 + ( b * 100)
    }
    else{
        var max = max(max(a,b),c)
        result = max * 100
    }

    println(result)
}


