// [백준] 1026. 보물 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine()); 
		ArrayList<Integer> arrA = new ArrayList<>();
		ArrayList<Integer> arrB = new ArrayList<>();
		int sum = 0;
		
		StringTokenizer a = new StringTokenizer(in.readLine());
		StringTokenizer b = new StringTokenizer(in.readLine());
		
		for(int i = 0; i<n; i++) {
			arrA.add(Integer.parseInt(a.nextToken()));
			arrB.add(Integer.parseInt(b.nextToken()));
		}
		
		for(int i = 0; i<n; i++) {
			// A의 최솟값과 B의 최댓값의 곱
			int min = Collections.min(arrA);
			int max = Collections.max(arrB);
			// 누적
			sum += (min * max);
			
			// 게산한 값 제외시킴
			arrA.remove(Integer.valueOf(min));
			arrB.remove(Integer.valueOf(max));
		}
		
		System.out.println(sum);
		in.close();
	}
}

