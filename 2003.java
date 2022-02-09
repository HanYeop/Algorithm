// [백준] 2003. 수들의 합 2 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int n;
	static int m;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	arr = new int[n];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}

    	System.out.println(twoPointer());
    }
    
    public static int twoPointer() {
    	int left = 0; 
    	int right = 0;
    	int sum = 0;
    	int count = 0;
    	
    	while (true) {
    		
    		// 1 + 3. L ~ R 까지의 부분배열의 합이 M 보다 크거나 같으면 L + 1
    		if(sum >= m) {
    			sum -= arr[left++];
    		}
    		// 종료 조건 (right이 마지막 범위를 넘어갔을 경우)
    		else if(right == n) {
    			break;
    		}
    		// 2. L ~ R 까지의 부분배열의 합이 M 보다 작으면 R + 1
    		else if(sum < m) {
    			sum += arr[right++];
    		}
    		// 3.L ~ R 까지의 부분배열의 합이 M 이면 결과 카운트 + 1
    		if(sum == m){
    			count++;
    		}
    	}	
    	return count;
    }
}
