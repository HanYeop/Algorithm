// [백준] 1913. 달팽이 (Java)
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main {
	static int[][] arr;
	static int n;
	static int x;
	// 상우하좌
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
  
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        x = Integer.parseInt(br.readLine());
        int resultRow = 0;
        int resultCol = 0;
        arr = new int[n][n];
        
        // 시간초과 방지
        StringBuilder sb = new StringBuilder();

        create();
 
        for(int i = 0 ; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		sb.append(arr[i][j] + " ");
        		// 입력받은 자연수 좌표 저장
        		if(arr[i][j] == x) {
        			resultRow = i + 1;
        			resultCol = j + 1;
        		}
        	}
        	sb.append("\n");
        }
        
        sb.append(resultRow + " " + resultCol);
        System.out.println(sb);
        
        br.close();
    }
    
    
    // 표 생성
    public static void create() {
    	int curRow = n / 2;
    	int curCol = n / 2;
    	
    	int next = 0;
    	int count = 0; // 같은 방향 이동 횟수
    	
    	int max = 1; // 최대 이동 횟수
    	int ls =0; // 방향 전환 횟수
    	
    	// n^2 만큼 반복
    	for(int i = 1; i <= n * n; i++) {
    		arr[curRow][curCol] = i;
    		
    		// 현재 방향으로 위치 한칸 이동
    		curRow += dx[next % 4];
    		curCol += dy[next % 4];
    		count++;
    			
    		// 방향전환 (최대 이동횟수만큼 그 방향으로 이동했다면)
    		if(count == max) {
    			next++;
    			count = 0;
    			ls++;
    		}
    		
    		// 방향전환 2번 될 때마다 최대 이동횟수 ++
    		if(ls == 2) {
    			max++;
    			ls = 0;
    		}
    	}
    }
}
