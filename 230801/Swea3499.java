package com.swea;

import java.util.Arrays;
import java.util.Scanner;

public class Swea3499 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			String[] fristArr = new String[n];
			String[] secondArr = new String[n];
						
			// n이 짝수일때
			if(n % 2 == 0) {
				// 앞, 뒷 배열에 반반씩 넣기
				for(int i = 0 ; i < n/2 ; i++) {
					fristArr[i] = sc.next();
				}
				for(int i = 0; i < n/2 ; i++) {
					secondArr[i] = sc.next();
				}			
			}
			// n이 홀수일때
			else {
				for(int i = 0 ; i < n/2 + 1 ; i++) {
					fristArr[i] = sc.next();
				}
				for(int i = 0 ; i < n/2 ; i++) {
					secondArr[i] = sc.next();
				}
			}
			
			String ans = "";
			int idx = 0;
			// 인덱스가 idx일때 firstArr와 secondArr가 둘다 null일때까지 반복
			while(fristArr[idx] != null || secondArr[idx] != null) {
				// secondArr가 null이 아니면 둘 다 더해줌
				if(secondArr[idx] != null) {
					ans+= fristArr[idx] + " " + secondArr[idx] + " ";					
				} else {
					ans+= fristArr[idx];
				}
				idx++;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
