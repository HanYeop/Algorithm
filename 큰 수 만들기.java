// [프로그래머스] 큰 수 만들기 (Java)

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int count = 0;
        Stack<Integer> s = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < number.length(); i++){            
            int value = (number.charAt(i) - '0');
            
            while(true){
                
                if(s.size() == 0){
                    s.add(value);
                    break;
                }
                
                if(count >= k || s.peek() >= value){
                    s.add(value);
                    break;
                }
                
                if(s.peek() < value){
                    s.pop();
                    count++;
                }
            }
        }
        
        while(count != k){
            s.pop();
            count++;
        }
        
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        
        answer = sb.reverse().toString();
        return answer;
    }
}
