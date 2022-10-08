// [프로그래머스] 두 큐 합 같게 만들기 (Kotlin)
import java.util.*

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = -2
        var count = 0
        
        val q1: Queue<Long> = LinkedList()
        val q2: Queue<Long> = LinkedList()
    
        for(i in queue1){
            q1.offer(i.toLong())
        }
        
        for(i in queue2){
            q2.offer(i.toLong())
        }
        
        var sum1 = queue1.sum().toLong()
        var sum2 = queue2.sum().toLong()

        while(sum1 != sum2){
            
            if(count >= queue1.size * 4){
                count = -1
                break
            }
            
            if(sum1 > sum2){
                val cur = q1.poll()
                q2.offer(cur)
                sum1 -= cur
                sum2 += cur
            }
            else if(sum2 > sum1){
                val cur = q2.poll()
                q1.offer(cur)
                sum1 += cur
                sum2 -= cur
            }
            count++
        }
        
        answer = count
        return answer
    }
}
