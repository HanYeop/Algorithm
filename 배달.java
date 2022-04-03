// [프로그래머스] 배달 (Java)
import java.util.*;

class Node implements Comparable<Node>{
    int des;
    int weight;
    
    public Node(int des, int weight){
        this.des = des;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node e){
        return this.weight - e.weight;
    }
}

class Solution {
    
    static PriorityQueue<Node> q = new PriorityQueue<Node>();
    static int[] dist;
    static ArrayList<Node>[] map;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        dist = new int[N + 1];
        map = new ArrayList[N + 1];
        
        for(int i = 0; i < N +1; i++){
            dist[i] = 500001;
            map[i] = new ArrayList<Node>();
        }
        
        for(int i = 0; i < road.length; i++){
            int start = road[i][0];
            int des = road[i][1];
            int weight = road[i][2];
            
            map[start].add(new Node(des,weight));
            map[des].add(new Node(start,weight));
        }
        dijkstra(1);
        
        for(int i = 1; i < N + 1; i++){
            if(dist[i] <= K){
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dijkstra(int srt){
        dist[srt] = 0;
        q.offer(new Node(srt,0));
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(dist[cur.des] < cur.weight){
                continue;
            }
            
            for(Node node : map[cur.des]){
                int nextDes = node.des;
                int nextWeight = cur.weight + node.weight;
                
                if(nextWeight < dist[nextDes]){
                    dist[nextDes] = nextWeight;
                    q.offer(new Node(nextDes,nextWeight));
                }
            }
        }
    }
}
