// [백준] 1002. 터렛 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.pow

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()

    for(i in 0 until n){
        val st = StringTokenizer(readLine())
        val x1 = st.nextToken().toInt()
        val y1 = st.nextToken().toInt()
        val r1 = st.nextToken().toInt()
        val x2 = st.nextToken().toInt()
        val y2 = st.nextToken().toInt()
        val r2 = st.nextToken().toInt()

        println(solve(x1,y1,r1,x2,y2,r2))
    }
}
fun solve(x1: Int, y1: Int, r1: Int, x2: Int, y2: Int, r2: Int): Int{
    val dis =
        ((x2 - x1).toDouble().pow(2.0) + (y2 - y1).toDouble().pow(2.0)).toInt()


    // case 1 : 중점이 같으면서 반지름도 같을 경우
    if(x1 == x2 && y1 == y2 && r1 == r2) {
        return -1;
    }

    // case 2-1 : 두 원의 반지름 합보다 중점간 거리가 더 길 때
    else if(dis > (r1 + r2).toDouble().pow(2).toInt()) {
        return 0;
    }

    // case 2-2 : 원 안에 원이 있으나 내접하지 않을 때
    else if(dis < (r2 - r1).toDouble().pow(2).toInt()) {
        return 0;
    }

    // case 3-1 : 내접할 때
    else if(dis == (r2 - r1).toDouble().pow(2).toInt()) {
        return 1;
    }

    // case 3-2 : 외접할 때
    else if(dis == (r1 + r2).toDouble().pow(2).toInt()) {
        return 1;
    }

    else {
        return 2;
    }
}
