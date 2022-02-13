// [백준] 10157. 자리배정 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 상우하좌
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int c = Integer.parseInt(st.nextToken());
    	int r = Integer.parseInt(st.nextToken());
    	int[][] arr = new int[r + 2][c + 2];
    	
    	for(int i = 0; i < (c + 2); i++) {
    		arr[0][i] = -1;
    		arr[r + 1][i] = -1;
    	}
    	
    	for(int i = 0; i < (r + 2); i++) {
    		arr[i][0] = -1;
    		arr[i][c + 1] = -1;
    	}
    	
    	int k = Integer.parseInt(br.readLine());
    	
    	// 좌석을 배정할 수 없는 경우
    	if(k > c * r) {
    		System.out.println(0);
    		return;
    	}
    	
    	int x = r; // 현재 x 좌표
    	int y = 1; // 현재 y 좌표
    	int value = 1; // 좌석
    	int dir = 0; // 방향 (상우하좌 => 0123)
    	
    	while(true) {
    		arr[x][y] = value;
    		// 대기번호 k 관객 좌석 위치 출력
    		if(value == k) {
    			System.out.println(y + " " + (r - x + 1));
    			break;
    		}
    		
    		// 이미 채워져있거나 벽을 만날때마다 방향 전환
    		if(arr[x + dx[dir]][y + dy[dir]] != 0) {
    			dir = (dir + 1) % 4;
    		}
    		x += dx[dir];
    		y += dy[dir];
    		
    		value++;
    		
    		// 좌석 최대
    		if(value > c * r) {
    			break;
    		}
    	}
    	
//    	// 좌석 배치 확인
//    	for(int i = 0; i < r + 2; i++) {
//    		for(int j = 0; j < c + 2; j++) {
//    			System.out.print(arr[i][j] + " ");
//    		}
//    		System.out.println();
//    	}
    }
}
