// [백준] 16916. 부분 문자열 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] table;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String s = br.readLine();
    	String p = br.readLine();
    	
    	makeTable(p);
    	
    	System.out.println(search(s, p));
    }
    
    public static int search(String str, String pattern) {
    	int sLen = str.length();
    	int pLen = pattern.length();
    	
    	int index = 0;
    	for(int i = 0; i < sLen; i++) {
    		while(index > 0 && str.charAt(i) != pattern.charAt(index)) {
    			index = table[index - 1];
    		}
    		
    		if(str.charAt(i) == pattern.charAt(index)) {
    			
    			if(index == pLen - 1) {
    				index = table[index];
    				return 1;
    			}
    			else {
    				index++;
    			}
    		}
    	}
    	return 0;
    }
    
    public static void makeTable(String pattern) {
		int pLen = pattern.length();
		table = new int[pLen];
		
		int index = 0;
		for(int i = 1; i < pLen; i++) {
			/* index > 0 => 문자열 매칭이 시작됨
			  	연속으로 일치하지 않으면 index 값을 돌려주어 다시 매칭 시작 */
			while(index > 0 && pattern.charAt(i) != pattern.charAt(index)) {
				index = table[index - 1];
			}
			
			if(pattern.charAt(i) == pattern.charAt(index)) {
				index += 1;
				table[i] = index;  
			}
		}
 	}
}
