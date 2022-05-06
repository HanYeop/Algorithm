// [백준] 7569. 토마토 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Xyz{
	int row;
	int col;
	int level;
	
	public Xyz(int row, int col, int level) {
		this.row = row;
		this.col = col;
		this.level = level;
	}
}

public class Main {
	
	static int m; // 가로 칸 수
	static int n; // 세로 칸 수
	static int h; // 쌓아 올려지는 상자 수
	static int count; // 걸리는 일수
	
	// 상하좌우(같은레벨)위아래(다른레벨)
	static int[] dx = {-1,1,0,0,0,0};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	
	static int[][][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		count = -1;
		
		Queue<Xyz> q = new LinkedList<Xyz>();
		
		map = new int[n][m][h];
		
		// 입력
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < m; k++) {
					map[j][k][i] = Integer.parseInt(st.nextToken());		
				}
			}
		}
		
		// 하나씩 익었는지 확인
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					// 익은 토마토 큐에 추가
					if(map[j][k][i] == 1) {
						q.offer(new Xyz(j,k,i));
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			count++;
			int size = q.size();
			
			// 큐의 깊이 기준으로 반복
			for(int i = 0; i < size; i++) {
				Xyz cur = q.poll();
				
				// 6방향 탐색
				for(int j = 0; j < 6; j++) {
					int x = cur.row + dx[j];
					int y = cur.col + dy[j];
					int z = cur.level + dz[j];
					
					// 범위 벗어나면
					if(x < 0 || y < 0 || z < 0 || x >= n || y >= m || z >= h ) {
						continue;
					}
					
					// 익을 수 있는 토마토
					if(map[x][y][z] == 0) {
						map[x][y][z] = 1;
						q.offer(new Xyz(x,y,z));
					}
				}
			}
		}
		
		// 하나씩 익었는지 확인
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					// 안 익은 토마토가 존재
					if(map[j][k][i] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		System.out.println(count);
	}	
}
