// [프로그래머스] 순위 (Kotlin)

class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        val graph = Array(n + 1) { Array(n + 1) {0}}
        
        for(i in results){
            graph[i[0]][i[1]] = 1 // 이김
            graph[i[1]][i[0]] = 2 // 짐
        }
        
        for(k in 1 until n + 1){
            for(i in 1 until n + 1){
                for(j in 1 until n + 1){
                    if(graph[i][k] == graph[k][j] && graph[i][k] != 0){
                        graph[i][j] = graph[i][k]
                    }
                }
            }   
        }
        
        for(i in 1 until n + 1){
            var count = 0
            
            for(j in 1 until n + 1){
                if(graph[i][j] != 0) count++
            }
            
            if(count == n - 1) answer++
        }
        
        return answer
    }
}
