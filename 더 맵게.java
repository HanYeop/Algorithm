// [프로그래머스] 더 맵게 (Java)
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
                
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville){
            pq.add(i);
        }
        
        while(true){
            int one = pq.poll();
            int two = pq.poll();
            
            pq.add(one + (two * 2));
            answer++;
            
            if(pq.peek() >= K){
                break;
            }
            if(pq.size() == 1){
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
}
