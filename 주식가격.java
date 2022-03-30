// [프로그래머스] 주식가격 (Java)
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        
        Stack<Integer> stack = new Stack<Integer>();
        int[] arr = new int[prices.length]; // 정답 배열
        
        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty()){
                int peek = prices[stack.peek()];
                
                // 새로 들어오는 값이 더 작은 경우 pop, 그 index 차이 만큼을 정답 배열에
                if(peek > prices[i]){
                    int pop = stack.pop();
                    arr[pop] = i - pop;
                }
                else{
                    break;
                }
            }
            // index 값 저장
            stack.add(i);
        }
        
        // 끝까지 가격이 떨어지지 않은 주식
        while(!stack.isEmpty()){
            int pop = stack.pop();
            arr[pop] = prices.length - pop - 1;
        }
        
        answer = arr;
        return answer;
    }
}
