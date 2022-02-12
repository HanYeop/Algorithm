// [백준] 2477. 참외밭 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int max;
	static int longest; // 가장 긴 변
	static int another; // 나머지 한 변
	static int smallrect; // 작은 사각형
	static int bigrect; // long * another (큰 사각형)
	static int[] arr;
	static StringTokenizer st;

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	k = Integer.parseInt(br.readLine());
    	arr = new int[6];
    	
    	for(int i = 0; i < 6; i++) {
    		st = new StringTokenizer(br.readLine());
    		st.nextToken();
    		int value = Integer.parseInt(st.nextToken());
    		
    		arr[i] = value;
    	}
    	
    	// 가장 긴 변 구하기
    	for(int i = 0; i < 6; i++) {
    		if(arr[longest] < arr[i]) {
    			longest = i;
    		}
    	}
    		
    	if(arr[(longest + 5) % 6] > arr[(longest + 1) % 6]) {
    		another = (longest + 5) % 6;
    	}
    	else {
    		another = (longest + 1) % 6;
    	}
    	  	
    	bigrect = arr[longest] * arr[another];
    	
    	if((longest + 1) % 6 == another) {
    		smallrect = arr[(longest + 3) % 6] * arr[(longest + 4) % 6];
    	}
    	else {
    		smallrect = arr[(longest + 2) % 6] * arr[(longest + 3) % 6];
    	}
    	
    	int result = bigrect - smallrect;
    	System.out.println(result * k);
    }
}
