// [프로그래머스] 가장 먼 노드 (Kotlin)

import java.util.*

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0
        val list = Array(n + 1) {arrayListOf<Int>()}
        val visit = Array(n + 1) { false }
        
        for(i in edge){
            list[i[0]].add(i[1])
            list[i[1]].add(i[0])
        }
        
        val q: Queue<Int> = LinkedList()
        q.offer(1)
        visit[1] = true
        while(q.isNotEmpty()){
            answer = 0
            val size = q.size // 2
        
            for(i in 0 until size){
                val top = q.poll()
                for(j in list[top]){
                    if(!visit[j]){
                        visit[j] = true
                        q.offer(j)
                    }
                }
                answer = size
            }
        }
        return answer
    }
}
