// [백준] 1244. 스위치 켜고 끄기 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
	static int num; // 스위치 개수
	static int[] state; // 스위치 상태
	static int student; // 학생 수
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        // 스위치 개수 입력
        num = Integer.parseInt(br.readLine());
        
        // 스위치 상태 입력
        state = new int[num + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < state.length; i++) {
        	state[i] = Integer.parseInt(st.nextToken());
        }
        
        // 학생수 입력
        student = Integer.parseInt(br.readLine());
        
        // 학생 스위치 처리
        for(int i = 0; i < student; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int gender = Integer.parseInt(st.nextToken());
        	
        	// 남자
        	if(gender == 1) {
        		man(Integer.parseInt(st.nextToken()));
        	}
        	// 여자
        	else if(gender == 2) {
        		women(Integer.parseInt(st.nextToken()));
        	}
        }
        
        for(int i = 1; i < state.length; i++) {
        	System.out.print(state[i] + " ");
        	if(i % 20 == 0) {
        		System.out.println();
        	}
        }
        br.close();
    }
    
    public static void man(int x) {
    	int cur = x;
    	// 배수 번호 스위치 상태 반대로 변경
    	while(cur < state.length) {
    		if(state[cur] == 0) {
    			state[cur] = 1;
    		}
    		else if(state[cur] == 1) {
    			state[cur] = 0;
    		}
    		cur += x;
    	}
    }
    
    public static void women(int x) { 	
    	// 현재 위치 스위치 상태 반대로 변경
    	if(state[x] == 0) {
			state[x] = 1;
		}
		else if(state[x] == 1) {
			state[x] = 0;
		}
    	
    	// 대칭 스위치 반대로 변경
    	int count = 1;
    	while((x - count) > 0 && (x + count) < state.length) {
    		if(state[x + count] == state[x - count]) {
    			
    			if(state[x + count] == 0) {
    				state[x + count] = 1;
    				state[x - count] = 1;
    			}
    			else if(state[x + count] == 1) {
    				state[x + count] = 0;
    				state[x - count] = 0;
    			}
    			count++;
    			
    		}
    		else {
    			break;
    		}
    	}
    }
}
