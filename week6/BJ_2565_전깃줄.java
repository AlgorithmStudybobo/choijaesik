package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_2565_전깃줄 {
	 static class Line implements Comparable<Line>{
		 int from, to;

		public Line(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}

		@Override
		public int compareTo(Line o) {
			return this.from - o.from;
		}
	 }
	
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 ArrayList<Line> lines = new ArrayList();
		 int[] dp = new int[501];
		 
		 // 전깃줄들은 최소 자기자신은(1개) 가능 -> 초기값 넣어주기
		 lines.add(new Line(0,0));
		 
		 int n = sc.nextInt();
		 
		 // 전깃줄 생성
		 for(int i = 0 ; i < n ; i++) lines.add(new Line(sc.nextInt(),sc.nextInt()));
		 
		 // 출발지 기준으로 정렬
		 Collections.sort(lines);
		 
//		 for(Line l : lines) System.out.println(l.from + " " + l.to);
		 dp[0] = 0;
		 for(int i = 1; i < lines.size(); i++) {
			  for(int j = i - 1; j >= 0; j--) {
				  if(lines.get(i).to > lines.get(j).to) dp[i] = Math.max(dp[i], dp[j] + 1);
			  }
		 }
//		 for(int i = 0 ; i < lines.size(); i++) System.out.println(dp[i]);
		 
		 int max = 0;
		 for(int i = 0; i < lines.size(); i++) max = dp[i] > max ? dp[i] : max;
		 System.out.println(n - max);
	}
}
