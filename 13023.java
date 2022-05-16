// [백준] 13023. ABCDE (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Algorithm {
	
	static int n; // 사람의 수
	static int m; // 친구 관계의 수
	static ArrayList<Integer>[] list; // 연결 리스트
	static boolean[] visit; // 방문 여부
	static int result = 0; // 정답 여부
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];
		for(int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		visit = new boolean[n + 1];
		
		// 관계 입력 (양방향)
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		// dfs
		for(int i = 0; i < n; i++) {
			visit[i] = true;
			dfs(i,0);
			visit[i] = false;
			
			// 정답 찾으면 바로 종료
			if(result == 1) {
				break;
			}
		}
		
		System.out.println(result);
	}	
	
	static void dfs(int x, int count) {
		
		// dfs 깊이가 4 이상이면 return
		if(count >= 4) {
			result = 1;
			return;
		}
		
		for(int i : list[x]) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i,count + 1);
				visit[i] = false;
			}
		}
	}
}
