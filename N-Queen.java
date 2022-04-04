// [프로그래머스] N-Queen (Java)
class Solution {
    static int[] col;
    static int result;
    static int N;
    
    public int solution(int n) {
        int answer = 0;
        N = n;
        col = new int[n];
        
        dfs(0);
        answer = result;
        return answer;
    }
    
    static void dfs(int x){
        if(x == N) {
            result++;
        }
        else{
            for(int i = 0; i < N; i++){
                col[x] = i;
                if(check(x)){
                    dfs(x + 1);
                }
            }
        }
    }
    
    static boolean check(int level){
        for(int i = 0; i < level; i++){
            if(col[i] == col[level] || Math.abs(col[level] - col[i]) == level - i){
                return false;
            }   
        }
        return true;
    }
}
