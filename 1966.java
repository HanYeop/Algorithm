// [백준] 1966. 프린터 큐 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int t; // 테스트 케이스 수
	static int n; // 문서의 개수
	static int m; // 궁금한 문서의 초기 위치
	static Queue<Integer> queue; // 문서의 중요도
	static Queue<Integer> indexQueue; // 문서의 인덱스
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	t = Integer.parseInt(br.readLine());
    	
    	for(int i = 0; i < t; i++) {    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		m = Integer.parseInt(st.nextToken());

    		queue = new LinkedList<>();
    		indexQueue = new LinkedList<>();
    		
    		st = new StringTokenizer(br.readLine());
    		// 중요도, 인덱스 입력
    		for(int j = 0; j < n; j++) {
    			queue.offer(Integer.parseInt(st.nextToken()));
    			indexQueue.offer(j);
    		}
    		
    		solve();
    	}
    }
    
    public static void solve() {
    	int count = 1; // 몇번 째 인쇄인지
    	
    	while (!queue.isEmpty()) {
    		int max = Collections.max(queue); // 현재 최우선 문서
    		int cur = queue.poll(); // 현재 문서
    		int curIndex = indexQueue.poll(); // 현재 인덱스
    		
    		// 인쇄 가능할 때
    		if(cur == max) {
    			// 찾는 문서를 인쇄했다면 몇번 째 인쇄인지 출력, break
    			if(curIndex == m) {
    				System.out.println(count);
    				break;
    			}
    			count++; // 인쇄할때마다 값 증가
    		}
    		// 인쇄 불가능하면 다시 맨 뒤에 넣어줌
    		else {
    			queue.offer(cur);
    			indexQueue.offer(curIndex);
    		}
    	}
    }
}
