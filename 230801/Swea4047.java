package com.swea;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Swea4047 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T; tc++) {
			
			String str = sc.next();
			HashSet<String> S = new HashSet<String>();
			HashSet<String> D = new HashSet<String>();
			HashSet<String> H = new HashSet<String>();
			HashSet<String> C = new HashSet<String>();
			
			int idx = 0;
			int sCnt = 0;
			int dCnt = 0;
			int hCnt = 0;
			int cCnt = 0;
			while(idx < str.length()) {
				
				char c = str.charAt(idx);
				switch(c) {
				case 'S':
					S.add(str.substring(idx+1, idx+3));
					sCnt++;
					break;
				case 'D':
					D.add(str.substring(idx+1, idx+3));
					dCnt++;
					break;
				case 'H':
					H.add(str.substring(idx+1, idx+3));
					hCnt++;
					break;
				case 'C':
					C.add(str.substring(idx+1, idx+3));
					cCnt++;
					break;
				}
				idx+=3;
			}
			
			//test
//			System.out.println(sCnt + " " + dCnt + " " + hCnt + " " + cCnt + " " );
//			System.out.println(S.size() + " " + D.size() + " " + H.size() + " " + C.size() + " " );
			
			System.out.print("#" + tc + " ");
			if(sCnt != S.size() || dCnt != D.size() || hCnt != H.size() || cCnt != C.size()) {
				System.out.println("ERROR");
			} else {
				System.out.printf("%d %d %d %d\n", 13-sCnt,13-dCnt,13-hCnt,13-cCnt);
			}
		}

	}

}
