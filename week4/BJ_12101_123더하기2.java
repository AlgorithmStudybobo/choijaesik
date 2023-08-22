package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 8/18 11:00 ~ 11:40
*/

public class BJ_12101_123더하기2 {
	
	static int n,k;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		numbers = new int[n];
		checked = new boolean[n];
		list = new ArrayList<>();
		중복순열(0,0);

		// k번째 오는 식이 없는경우
		if(list.size() < k) {
			System.out.println(-1);
			return;
		}
		
		// 리스트에 넣을 때 0부터 넣어서 1 빼줌
		k--;
		
		// 출력
		for(int i = 0 ; i < list.get(k).length; i++) {
			if(i == list.get(k).length-1) {
				 System.out.print(list.get(k)[i]);
				 return;
			}
			System.out.print(list.get(k)[i] + "+");
		}
	}

	static int numbers[];
	static boolean checked[];
	static ArrayList<int[]> list;
	static int[] arr = {1,2,3};
	// 중복순열
	private static void 중복순열(int cnt, int sum) {
		
		if(sum > n) return;
		// sum이 n에 도달하면 배열 저장
		if(sum == n) {
			list.add(Arrays.copyOfRange(numbers, 0, cnt));
			return; 
		}
		
		for(int i = 0 ; i < 3; i++) {
			numbers[cnt] = arr[i];
			중복순열(cnt + 1, sum + arr[i]);
		}
		
	}

}
