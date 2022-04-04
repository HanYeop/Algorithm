// [프로그래머스] 숫자의 표현 (Java)
class Solution {
    
    public int solution(int n) {
        int answer = 0;
        int left = 0;
        int sum = 0;
        
        for(int i = 1; i <= n; i++){
            sum += i;
            
            // 범위에서 벗어나면 앞에서부터 줄여나가면서 범위에 맞춤
            while(sum > n){
                sum -= left;
                left++;
            }
            
            // 정답 찾을때 마다 ++
            if(sum == n){
                answer++;
            }
        }   
        return answer;
    }
}
