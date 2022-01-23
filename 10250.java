// [백준] 10250. ACM 호텔 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine()); 
		for (int i = 0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int a = n%h;
			int b = (n/h)+1;
			if(a==0) {
				a = h;
				b -= 1;
			}
			int tmp = a*100 + b;
			System.out.println(tmp);
		}
		in.close();
	}
}
