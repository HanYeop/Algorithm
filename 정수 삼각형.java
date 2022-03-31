// [프로그래머스] 정수 삼각형 (Java)
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int size = triangle.length;
        int[][] dp = new int[size][size];
        
        for(int i = 0; i < size; i++){
            dp[size - 1][i] = triangle[size - 1][i];
        }
        
        for(int i = (size - 2); i >= 0; i--){
            for(int j = 0; j <= i; j++){
                int cur = triangle[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
                dp[i][j] = cur;
            }
        }

        answer = dp[0][0];
        return answer;
    }
}
