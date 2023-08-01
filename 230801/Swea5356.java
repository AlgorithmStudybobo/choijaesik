package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;;

public class Swea5356 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException{

		int t = Integer.parseInt(br.readLine()); 
		int size = 5;
		for(int tc = 1; tc <= t; tc++) {
			
			String [] arr = new String[size];
			String ans = "";
			int max = 0;
			
			for(int i = 0 ; i < size; i++) {
				arr[i] = br.readLine();	
				
				if(max < arr[i].length()) max = arr[i].length();
			}
			
			for(int i = 0 ; i < max; i++) {
				for(int j = 0 ; j < size; j++) {
					// 끝난 문자열일경우 패스
					if(i >= arr[j].length()) continue;
					ans += arr[j].charAt(i);
				}
			}
			System.out.println("#" + tc + " " + ans);
			
		}
		 
	}

}
