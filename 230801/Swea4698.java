
import java.util.Scanner;

public class Swea4698 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			String d = sc.next();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			for(int i = a; i <= b; i++) {
				int j = 0;
				// 소수인지 체크
				for(j = 2 ; j < i; j++) {	
					if(i % j == 0) {
						break;
					}
				}		
				if(j == i) {	
					// d포함하는지 체크
					if(Integer.toString(i).contains(d)) {
						
					}
				}
				
			}
			System.out.println("#" + tc + " ");
		}	
	}
}
