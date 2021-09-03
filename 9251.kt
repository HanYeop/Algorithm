import java.util.*
import kotlin.math.max

var str1 =""
var str2 =""
lateinit var dp : Array<Array<Int>>

fun main() = with(Scanner(System.`in`)){
    str1 = nextLine()
    str2 = nextLine()
    var max = 0

    dp = Array(str2.length+1){Array(str1.length+1){0} }

    for(i in str2.indices){
        find(i)
    }

    for(i in 0 until str2.length+1){
        for(j in 0 until str1.length+1){
//            print("${dp[i][j]} ")
            max = max(dp[i][j],max)
        }
//        println()
    }

    println(max)

}

fun find(twoIndex: Int){
    for(oneIndex in str1.indices){
        if(str1[oneIndex] == str2[twoIndex]){
            dp[twoIndex+1][oneIndex+1] = dp[twoIndex][oneIndex]+1
        }
        else{
            dp[twoIndex+1][oneIndex+1] = max(dp[twoIndex][oneIndex+1],dp[twoIndex+1][oneIndex])
        }
    }
}
