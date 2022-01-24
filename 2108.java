// [백준] 2108. 통계학 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine()); 
		int[] arr = new int[n]; // 숫자 저장할 배열
		int a = 0; // 산술평균
		int b = 0; // 중앙값
		int c = 0; // 최빈값
		int d = 0; // 범위
		
		// 숫자 입력
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		// 산술평균
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum += arr[i];
		}
		a = (int)Math.round(((double)sum /n));
		
		// 중앙값
		Arrays.sort(arr);
		b = arr[n/2];

		// 최빈값
		int[] plus = new int[4002];
		int[] minus = new int[4001];
		for(int i=0;i<n;i++) {
			// 0 ~ 4000 빈도 저장
			if(arr[i] <0) {
				minus[Math.abs(arr[i])]++;
			}
			
			// -1 ~ -4000 빈도 저장
			else {
				plus[arr[i]]++;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		// 가장 높은 빈도수 체크
		int max = 0;
		for(int i=0; i<plus.length;i++) {
			max = Math.max(max, plus[i]);
			
		}
		for(int i=0; i<minus.length;i++) {
			max = Math.max(max, minus[i]);
		}
		
		// 가장 빈도 높은 숫자들 따로 ArrayList에 담기
		for(int i : arr) {
			if(i<0) {
				if(minus[Math.abs(i)] == max && !(list.contains(i))) {
					list.add(i);
				}
			}
			else {
				if(plus[i] == max && !(list.contains(i))) {
					list.add(i);
				}
			}
		}
		
		// 2개 이상이면 2번째로 작은 것 출력
		if(list.size()>=2) {
			c = list.get(1);
		}
		// 1개면 그대로
		else {
			c = list.get(0);
		}
		
		// 범위
		d = arr[n-1] - arr[0];
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		in.close();
	}
}

