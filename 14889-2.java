// [백준] 14889. 스타트와 링크 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int min = 101;
	static int[][] arr;
	static boolean[] visit;
	static StringTokenizer st;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	n = Integer.parseInt(br.readLine());
    	arr = new int[n + 1][n + 1];
    	visit = new boolean[n + 1];
    	
    	// 능력치 입력
    	for(int i = 1; i <= n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 1; j <= n; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	combi(1, n / 2);
    	
    	System.out.println(min);
    }
    
    // 조합 생성
    public static void combi(int index, int count) {
    	if(count == 0) {
    		solve();
    		return;
    	}
    	
    	// start 팀 조합 생성
    	for(int i = index; i <= n; i++) {
    		visit[i] = true; 
    		combi(i + 1, count - 1);
    		visit[i] = false;
    	}
    }
    
    // 조합별 능력치 차이 최솟값 찾기
    public static void solve() {
    	int startSum = 0;
    	int linkSum = 0;
    	
    	for(int i = 1; i <= n - 1; i++) {
    		for(int j = i + 1; j <= n; j++) {
    			if(visit[i] == true && visit[j] == true) {
    				startSum += arr[i][j] + arr[j][i];
    			}
    			else if(visit[i] == false && visit[j] == false) {
    				linkSum += arr[i][j] + arr[j][i];
    			}
    		}
    	}
    	
    	int result = Math.abs(startSum - linkSum);
    	min = Math.min(min, result);
    	
    	// 0보다 작을 순 없으므로 즉시 종료
    	if(min == 0) {
    		System.out.println(min);
    		System.exit(0);
    	}
    }
}
