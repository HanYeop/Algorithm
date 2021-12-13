// [백준] 10773. 제로 (Kotlin)

fun main() = with(System.`in`.bufferedReader()){
    val k = readLine().toInt()
    val stack = arrayListOf<Int>()

    for(i in 0 until k){
        val tmp = readLine().toInt()
        if(tmp == 0) stack.removeAt(stack.size-1)
        else stack.add(tmp)
    }

    println(stack.sum())
}
