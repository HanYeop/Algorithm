// [백준] 16918. 봄버맨 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// 상우하좌
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int r = Integer.parseInt(st.nextToken());
    	int c = Integer.parseInt(st.nextToken());
    	int n = Integer.parseInt(st.nextToken());
    	
    	String[][] mapOne = new String[r][c]; // 1
    	String[][] mapTwo = new String[r][c]; // 2,4,6,8,10
    	String[][] mapThree = new String[r][c]; // 3,7,11
    	String[][] mapFour = new String[r][c]; // 5,9
    	
    	for(int i = 0; i < r; i++) {
    		for(int j = 0; j < c; j++) {
    			mapTwo[i][j] = "O";
    			mapThree[i][j] = "O";
    			mapFour[i][j] = "O";
    		}
    	}
    	
    	// 입력
    	for(int i = 0; i < r; i++) {
    		String str = br.readLine();
    		for(int j = 0; j < c; j++) {
    			mapOne[i][j] = String.valueOf(str.charAt(j));
    			
    			// 폭탄이라면
    			if(mapOne[i][j].equals("O")) {
    				
    				mapThree[i][j] = ".";
    				
    				for(int k = 0; k < 4; k++) {
    					int nextX = i + dx[k];
    					int nextY = j + dy[k];
    					
    					if(nextX < 0 || nextY < 0 || nextX >= r || nextY >= c) {
    						continue;
    					}   			
    					mapThree[nextX][nextY] = ".";
    				}
    			}
    		}
    	}
    	
    	for(int i = 0; i < r; i++) {
    		for(int j = 0; j < c; j++) {    			
    			// 폭탄이라면
    			if(mapThree[i][j].equals("O")) {
    				
    				mapFour[i][j] = ".";
    				
    				for(int k = 0; k < 4; k++) {
    					int nextX = i + dx[k];
    					int nextY = j + dy[k];
    					
    					if(nextX < 0 || nextY < 0 || nextX >= r || nextY >= c) {
    						continue;
    					}   			
    					mapFour[nextX][nextY] = ".";
    				}
    			}
    		}
    	}
    	
    	if(n == 1) {
    		for(int i = 0; i < r; i++) {
        		for(int j = 0; j < c; j++) {
        			System.out.print(mapOne[i][j]);
        		}
        		System.out.println();
        	}
    	}
    	else if(n % 4 == 1) {
    		for(int i = 0; i < r; i++) {
        		for(int j = 0; j < c; j++) {
        			System.out.print(mapFour[i][j]);
        		}
        		System.out.println();
        	}
    	}
    	else if(n % 4 == 3) {
    		for(int i = 0; i < r; i++) {
        		for(int j = 0; j < c; j++) {
        			System.out.print(mapThree[i][j]);
        		}
        		System.out.println();
        	}
    	}
    	// 짝수
    	else {
    		for(int i = 0; i < r; i++) {
        		for(int j = 0; j < c; j++) {
        			System.out.print(mapTwo[i][j]);
        		}
        		System.out.println();
        	}
    	}
	}
}
