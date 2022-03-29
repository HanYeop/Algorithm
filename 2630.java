// [백준] 2630. 색종이 만들기 (Java)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] graph;
	static int white;
	static int blue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0,0,n);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	public static void solve(int row, int col, int x) {
		
		if(colorCheck(row, col, x)) {
			if(graph[row][col] == 0) {
				white++;
			}
			else {
				blue++;
			}
			return;
		}
		
		int size = x / 2;
		solve(row,col,size);
		solve(row + size,col,size);
		solve(row,col + size,size);
		solve(row + size,col + size,size);
	}
	
	
	public static boolean colorCheck(int row, int col, int size) {
	
		int color = graph[row][col];
		
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				if(graph[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
}
