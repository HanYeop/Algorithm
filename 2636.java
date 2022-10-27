// [백준] 2636. 치즈 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Pair{
	int x;
	int y;
	
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[][] arr = new int[r][c];
		int[][] visited;
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) arr[i][j] = -1;
			}
		}
		
		
		
		int time = 0; // 시간이자, 현재 녹을 수 있는 치즈 판별용
		int[] count = new int[100]; // 1시간 전 치즈 개수
		
		while(true) {
			
			// 치즈 개수
			int cheese = 0;
			time++;
			
			visited = new int[r][c];
			Queue<Pair> q = new LinkedList<Pair>();
			
			q.add(new Pair(0,0));
			visited[0][0] = 1;
			
			while(!q.isEmpty()) {
				Pair cur = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					
					// 범위를 넘어가면
					if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
						continue;
					}
					
					// 이미 방문했으면
					if(visited[nx][ny] == 1) {
						continue;
					}
					
					// 치즈면
					if(arr[nx][ny] == -1) {
						continue;
					}
					
					q.add(new Pair(nx,ny));
					visited[nx][ny] = 1;
				}
			}
			
			// 전체 탐색
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					// 치즈가 있으면
					if(arr[i][j] == -1) {
						cheese++;				
						
						// 상하좌우 판별
						for(int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
	
							// 범위 밖
							if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
								break;
							}
															
							// 주변에 막힌게 있으면
							if(visited[nx][ny] == 1) {
								arr[i][j] = time;
								break;
							}					
						}
					}
				}
			}
			
			count[time] = cheese;
			
			// 치즈가 하나도 없으면 종료
			if(cheese == 0) {
				break;
			}
		}
			
		System.out.println(time - 1);
		System.out.println(count[time - 1]);
	}
}
