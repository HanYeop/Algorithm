// [백준] 14502. 연구소 (Java)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int n; // 세로 크기
	static int m; // 가로 크기
	static int max; // 최대 영역
	static int[][] arr; // 원본 배열
	static int[][] tmpArr; // 복사 배열
	
	// 상하좌우
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		tmpArr = new int[n][m];
		
		// 연구소 입력
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 벽 만들기
		for(int i = 0; i < n; i++) {	
			for(int j = 0; j < m; j++) {
				// 빈 칸일때 벽 만들기
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					block(1);
					arr[i][j] = 0;			
				}
			}
		}	
		
		System.out.println(max);
	}
	
	public static void createTmp() {
		for(int i = 0; i < n; i++) {	
			for(int j = 0; j < m; j++) {
				tmpArr[i][j] = arr[i][j];
			}
		}
	}
	
	public static void block(int count) {	
		// 벽 3개 만들어 졌을 때
		if(count == 3) {
			createTmp(); // 복사본 생성
			dfs(); // 복사본으로 dfs
			countCheck(); // 복사본 영역 체크
			return;
		}
		
		for(int i = 0; i < n; i++) {	
			for(int j = 0; j < m; j++) {		
				// 빈 칸일때 벽 만들기
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					block(count + 1);
					arr[i][j] = 0;
				}
			}
		}
	}
	
	public static void dfs() {
		for(int i = 0; i < n; i++) {	
			for(int j = 0; j < m; j++) {
				// 바이러스 일 때만 탐색 시작
				if(tmpArr[i][j] == 2) {
					solve(i,j);
				}
			}
		}
	}
	
	public static void solve(int x, int y) {
		tmpArr[x][y] = 2;
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			// 범위 체크
			if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
				// 바이러스면 감염 시킴
				if(tmpArr[nextX][nextY] == 0) {
					solve(nextX,nextY);
				}
			}
		}
	}
	
	// 안전 영역 카운트
	public static void countCheck() {
		int count = 0;
		for(int i = 0; i < n; i++) {	
			for(int j = 0; j < m; j++) {
				// 빈 칸 갯수
				if(tmpArr[i][j] == 0) {
					count++;
				}
			}
		}
		max = Math.max(max, count);
	}
}
