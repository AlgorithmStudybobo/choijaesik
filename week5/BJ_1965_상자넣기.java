package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1965_상자넣기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n ; i++) arr[i] = sc.nextInt();
		
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		
		for(int i = 1 ; i < n; i++) {
			for(int j = i-1; j >= 0; j--) {
				if(arr[i] > arr[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
				else if(arr[i] == arr[j]) dp[i] = Math.max(dp[j], dp[i]);
			}
//			System.out.println(dp[i]);
		}
		
		Arrays.sort(dp);
		System.out.println(dp[n-1]);
	}

}
