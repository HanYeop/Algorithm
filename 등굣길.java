// [프로그래머스] 등굣길 (Java)
class Solution {
    static int[][] dp;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        dp = new int[n][m];
        for(int i = 0; i < puddles.length; i++){
            int y = puddles[i][0] - 1;
            int x = puddles[i][1] - 1;
            dp[x][y] = -1;
        }
        
        dp[0][0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(dp[i][j] == -1) {
                    continue;
                }
                
                if(j != 0){
                    if(dp[i][j - 1] != -1){
                       dp[i][j] += dp[i][j - 1];  
                    }
                }
                if(i != 0){
                    if(dp[i - 1][j] != -1){
                        dp[i][j] += dp[i - 1][j];
                    }
                }
                
                dp[i][j] %= 1000000007;
            }
        }
        
        answer = dp[n - 1][m - 1] % 1000000007;
        
        return answer;
    }
}
