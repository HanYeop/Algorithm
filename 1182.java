// [백준] 1182. 부분수열의 합 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int s = Integer.parseInt(st.nextToken());
    	int[] arr = new int[n];
    	int result = 0;
    	
    	// 배열 입력
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	// 부분 집합 전부 구하기
    	int sum = 0;
    	for(int i = 1; i < (1 << n); i++) {
    		sum = 0;
    		for(int j = 0; j < n; j++) {
    			if( (i & (1 << j)) != 0) {
    				sum += arr[j]; // 부분 집합의 합			
    			}
    		}
    		
    		// 합이 s일 경우
    		if(sum == s) {
    			result++;
    		}
    	}
    	
    	System.out.println(result);
    }
}
