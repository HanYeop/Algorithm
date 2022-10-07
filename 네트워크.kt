// [프로그래머스] 네트워크 (Kotlin)

class Solution {
    
    val dis = arrayListOf<Int>()
    
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        
        fun dfs(x: Int){
            for(i in 0 until n){
                if(dis.contains(i) && computers[x][i] == 1){
                    dis.remove(i)
                    dfs(i)
                }
            }
        }
        
        for(i in 0 until n){
            dis.add(i)
        }
        
        while(dis.size > 0){
            answer++
            dfs(dis.removeAt(0))
        }
        
        return answer
    }
}
