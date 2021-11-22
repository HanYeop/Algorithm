// [백준] 7568. 덩치 (Java)
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][3];

        for(int i =0; i<n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        
        for(int i = 0; i<n; i++) {
        	int count = 1; // 등수
          
          // 자신을 제외한 전부와 비교하여 더 큰 사람 존재할때마다 등수 +1
        	for(int j = 0; j<n; j++) {
        		if(i == j) continue;
        		else if(arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1]) {
    				count++;
    			}        	
        	}
        	arr[i][2] = count;
        }

        for(int i=0; i<n; i++) {
        	System.out.print(arr[i][2] +" ");
        }
    }
}
