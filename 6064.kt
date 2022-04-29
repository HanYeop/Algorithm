// [백준] 6064. 카잉 달력 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val t = readLine().toInt()

    repeat(t){
        val (m,n,x,y) = readLine().split(" ").map { it.toInt() }
        var result = -1

        // 최소 공배수
        val max = if(m > n) (m * n) / gcd(m,n) else (m * n) / gcd(n,m)

        // x 번째 해부터 시작
        var k = x

        // 최대 범위 까지만
        while(k <= max){
            var curY = k % n

            if(curY == 0) {
                curY = n
            }

            // y값 찾으면 종료
            if(curY == y) {
                result = k
                break
            }

            k += m
        }

        println(result)
    }
}

// 최대 공약수
fun gcd(a: Int, b: Int) : Int{
    return if(b == 0) a else gcd( b, a % b)
}


