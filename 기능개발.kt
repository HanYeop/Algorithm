// [프로그래머스] 기능개발 (Kotlin)
import java.util.*

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        var queue : Queue<Int> = LinkedList<Int>() // 완성되는 날 저장
        var result = arrayListOf<Int>() // 결과값 저장
        
        for(i in progresses.indices){
            val remain = 100 - progresses[i] // 남은 작업량
            val curSpeed = speeds[i]
            var result = 0
            
            if(remain % curSpeed == 0){
                result = remain / curSpeed    
            }
            else{
                result = remain / curSpeed + 1
            }
            queue.offer(result)    
        }
        
        while(queue.isNotEmpty()){
            var curValue = 1 // 배포 가능한 개수
            var cur = queue.poll() // 현재 기준값
            
            while(queue.isNotEmpty()){
                if(queue.peek() <= cur){
                    queue.poll()
                    curValue++
                }
                else{
                    break
                }
            }
            
            result.add(curValue)
        }
        
        answer = result.map { i -> i }.toIntArray()
        return answer
    }
}
