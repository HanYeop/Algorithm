// [백준] 2252. 줄 세우기 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int n; // 학생 수
	static int m; // 비교횟수 
	static ArrayList<ArrayList<Integer>> graph; // 관계 그래프
	static int[] visit; // 방문 그래프
	static StringBuffer sb;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	graph = new ArrayList<>();
    	
    	// 학생 수 만큼의 ArrayList 할당
    	for(int i = 0; i <= n; i++) {
    		graph.add(new ArrayList<>());
    	}
		visit = new int[n+1];
		
		sb = new StringBuffer("");
    	
    	// 그래프 반대로 그리기
    	for(int i = 0; i < m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		graph.get(y).add(x);
    	}
    	
    	for(int i = 1; i <= n; i++) {
    		if (visit[i] == 0) {
    			dfs(i);
    		}
    	}
    	
    	System.out.println(sb.toString());
    }
    
    // 제일 나중에 도착한 지점이 먼저 나옴 (stack)
    public static void dfs(int x) {
    	visit[x] = 1;
    	
    	// ArrayList 전체 탐색
    	for(int next : graph.get(x)) {
    		if(visit[next] == 0) {
    			dfs(next);
    		}
    	}
    	
    	sb.append(x + " ");
    }
}
