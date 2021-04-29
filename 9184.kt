
// 3차원 배열 생성 (20넘으면 필요X)
val dp  = Array(21){Array(21){Array(21){0} } }

fun main() = with(System.`in`.bufferedReader()){

    while(true){
        val n = readLine()
        if(n == "-1 -1 -1") break
        val arr = n.split(" ").map { it.toInt() }.toTypedArray()
        println("w(${arr[0]}, ${arr[1]}, ${arr[2]}) = ${w(arr[0],arr[1],arr[2])}")
    }
}

// 결과값을 dp에 저장해서 저장된 값을 불러옴
fun w(a : Int, b : Int, c : Int) : Int{

    when{
        a<=0 || b<=0 || c<=0 -> {
            return 1
        }
        a>20 || b>20 || c>20 -> {
            dp[20][20][20] = w(20,20,20)
            return dp[20][20][20]
        }
        a<b && b<c -> {
            if (dp[a][b][c] != 0) {
                return dp[a][b][c]
            }
            dp[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c)
            return dp[a][b][c]
        }
    }

    if (dp[a][b][c] != 0) {
        return dp[a][b][c]
    }
    dp[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1)
    return dp[a][b][c]
}
