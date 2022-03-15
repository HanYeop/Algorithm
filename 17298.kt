// [백준] 17298. 오큰수 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val list = arrayListOf<Int>()
    val stack = Stack<Int>()
    val sb = StringBuilder()

    for(i in 0 until n){
        val next = st.nextToken().toInt()
        list.add(next)
    }

    for(i in 0 until list.size){
        // 스택이 비어있지않고, 오큰수를 찾았을 때 pop 하여 index 값을 오큰수로 변경
        while(stack.isNotEmpty() && list[stack.peek()] < list[i]){
            list[stack.pop()] = list[i]
        }
        stack.push(i) // 인덱스값 push
    }

    // 스택에 남아있는 인덱스는 오큰수를 찾지 못한 것
    while(stack.isNotEmpty()){
        list[stack.pop()] = -1
    }

    for(i in 0 until list.size){
        sb.append("${list[i]} ")
    }

    println(sb)
}


