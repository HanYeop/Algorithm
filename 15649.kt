// [백준] 15649. N과 M (1) (Kotlin)

import java.util.*
import kotlin.collections.ArrayList

fun main() = with(Scanner(System.`in`)){
    val n = nextInt()
    val m = nextInt()

    fun find(arr: ArrayList<Int>){
        if(arr.size == m) {
            arr.forEach { print("$it ") }
            println()
            return
        }

        for(i in 1 .. n){
            if(!arr.contains(i)){
                val curArr = ArrayList<Int>()
                curArr.addAll(arr)
                curArr.add(i)
                find(curArr)
            }
        }
    }

    for(i in 1 .. n){
        find(arrayListOf(i))
    }
}
