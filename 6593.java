// [백준] 6593. 상범 빌딩 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int level;
	int row;
	int col;
	
	public Point(int level, int row, int col) {
		this.level = level;
		this.row = row;
		this.col = col;
	}
}

public class Algorithm {
	static int l; // 층 수
	static int r; // 행 수
	static int c; // 열 수
	static int[][][] map;
	static int sl; // 시작 층
	static int sx; // 시작 행
	static int sy; // 시작 열
	static int count;
	static StringTokenizer st;
	static Queue<Point> q;
	
	// 동,서,남,북,상,하
	static int[] dl = {0,0,0,0,-1,1};
	static int[] dx = {0,0,1,-1,0,0};
	static int[] dy = {1,-1,0,0,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			q = new LinkedList<Point>();
			count = 0;
			
			// 0,0,0 입력시 종료
			if(l == 0 && r == 0 && c == 0) {
				return;
			}
			
			map = new int[l][r][c];
			
			for(int i = 0; i < l; i++) {
				for(int j = 0; j < r; j++) {
					String str = br.readLine();
					for(int k = 0; k < c; k++) {
						char cur = str.charAt(k);
						
						if(cur == 'S') {
							map[i][j][k] = 2;
							sl = i;
							sx = j;
							sy = k;
						}
						else if(cur == '.') {
							map[i][j][k] = 0;
						}
						else if(cur == '#') {
							map[i][j][k] = 1;
						}
						else if(cur == 'E') {
							map[i][j][k] = 3;
						}
					}
				}
				br.readLine();
			}
			
			int result = solve();
			if(result == -1) {
				System.out.println("Trapped!");
			}
			else {
				System.out.println("Escaped in " + result + " minute(s).");
			}
		}
	}
	
	static int solve() {
		
		q.offer(new Point(sl,sx,sy));
		map[sl][sx][sy] = 100; // 방문 처리
		
		while(!q.isEmpty()) {
			
			count++;
			int size = q.size();
			
			// 큐의 깊이 만큼 반복하여 깊이 체크 (count) 
			for(int i = 0; i < size; i++) {
				Point cur = q.poll();
				
				for(int j = 0; j < 6; j++) {
					int cl = cur.level + dl[j];
					int cx = cur.row + dx[j];
					int cy = cur.col + dy[j];
						
					// 범위를 벗어나면
					if(cl < 0 || cl >= l || cx < 0 || cx >= r || cy < 0 || cy >= c) {
						continue;
					}
					
					// 출구에 도착하면
					if(map[cl][cx][cy] == 3) {
						return count;
					}
					
					// 방문한 곳이거나 벽이면
					if(map[cl][cx][cy] != 0) {
						continue;
					}
					
					map[cl][cx][cy] = 100; // 방문 처리
					q.offer(new Point(cl,cx,cy));
				}
			}
		}
		
		return -1;
	}
}
