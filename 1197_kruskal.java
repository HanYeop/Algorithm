// [백준] 1197. 최소 스패닝 트리 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 간선 정보 클래스
class Edge implements Comparable<Edge>{
	int v1;
	int v2;
	int weight;
	
	public Edge(int v1, int v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
	
	// 우선 순위 큐 활용
	@Override
	public int compareTo(Edge e) {
        return weight - e.weight;
    }
}
	
public class Main {
	static StringTokenizer st;
	static int v; // 정점의 개수
	static int e; // 간선의 개수
	static int[] parent;
	static PriorityQueue<Edge> queue; // 간선 정보 저장
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	st = new StringTokenizer(br.readLine());
    	
    	v = Integer.parseInt(st.nextToken());
    	e = Integer.parseInt(st.nextToken());
    	queue = new PriorityQueue<>();
    	parent = new int[v + 1];
    	
    	// 부모노드 세팅
    	for(int i = 1; i <= v; i++) {
    		parent[i] = i;
    	}
    	
    	// 간선 정보 입력
    	for(int i = 0; i < e; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int v1 = Integer.parseInt(st.nextToken());
    		int v2 = Integer.parseInt(st.nextToken());
    		int weight = Integer.parseInt(st.nextToken());
    		
    		queue.offer(new Edge(v1,v2,weight));
    	}
    	
    	// 사이클 확인 (union-find)
    	int weight = 0;
        while(!queue.isEmpty()) {
            Edge cur = queue.poll(); // 가중치가 가장 작은 간선
            // 부모노드가 다를때만 (사이클X)
            if(find(cur.v1) != find(cur.v2)) {
                union(cur.v1, cur.v2);
                weight += cur.weight;
            }
        }
        
        System.out.println(weight);
    	
    }   
    
    // 합치기
    public static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        
        if(p1 < p2)
            parent[p2] = p1;
        else
            parent[p1] = p2;
    }
    
    // 부모 노드 찾기
    public static int find(int n) {
        if(parent[n] == n) {
        	return n;
        }   
        return parent[n] = find(parent[n]);
    }
}
