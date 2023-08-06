

import java.util.Scanner;

/*	랜선 자르기
 * 
 *  1) 제일 짧은 랜선길이로 1씩 줄여가며 각 랜선의 길이를 나눈 값을 더해 N이 될때까지 반복 
 *   1-1) 문제 잘못읽음 / N개보다 많이 만드는 것도 되고 꼭 모든 랜선을 쓸 필요는 없음 -> 제일 긴걸로 바꿨는데 시간초과
 *  2) 이분탐색 - logN
 *   2-1) 이분탐색 썼는데 자꾸 답이 1개씩 추가돼서 나오는데 이유를 모르겠음..
 *   2-2) 다른사람 풀이 - 중복된 요소를 갖는 배열의 이분탐색시 upper, lower bound라는 개념이 있는데 
 *  				   이분탐색을 통해 중복되는 요소들의 상한(중복되는 요소의 최대 인덱스 + 1)과 하한(중복되는 요소의 최소 인덱스)을 찾음.
 *  
 *  lower :  찾는것보다 배열[현재 인덱스] 값이 더 크거나 같으면 왼쪽으로 범위 좁히기
 *  higher : 찾는것보다 배열[현재 인덱스] 값이 더 작으면 오른쪽으로 범위 좁히기
 *  
*/
public class Boj1654 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        
        long[] len = new long[k];
        long max = 0;
        for(int i = 0 ; i < k; i++) {
        	len[i] = sc.nextInt();
        	if(max < len[i]) max = len[i];
        }
        
        long low = 1, high = max, mid = 0 , ans = 0;
        long cnt = 0;
        
        while(low <= high) {  
        	
//        	System.out.println(low + " " + high);
        	cnt = 0;        
        	mid = (low + high) / 2;

        	// 각 랜선을 단위(mid)로 잘랐을때 나오는 랜선 수 : cnt
        	for(int i = 0 ; i < k; i++) { 	
        		cnt += len[i] / mid;
        	}       	
        	// 랜선수가 목표보다 적게나오면 단위를 줄이기
        	if(cnt < n) {
        		high = mid - 1;
        	}
        	// 랜선수가 목표보다 많거나 같게 나오면 단위를 키우기
        	else{
        		ans = mid;
        		low = mid + 1;
        	}   	        	
        }   
    
        System.out.println(ans);
        
    }

}