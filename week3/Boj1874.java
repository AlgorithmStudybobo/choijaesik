package boj;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
 * 시작  : 230812 10:30 
 * 스택에 1부터 차례대로 넣으며 입력값과 비교하며 답 저장
 * 
*/

public class Boj1874 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> s = new Stack<>();
		
		ArrayList<String> ans = new ArrayList<>();
		
		int input = 0;
		// 초기값 스택에 저장
		int now = 1;
		s.push(now++);
		ans.add("+");
		// 입력된 값이 스택의 top과 다르다면 now를 하나씩 증가시키며 스택에 저장
		while(n-- > 0) {

			input = sc.nextInt();
			// 입력된 값까지 스택에 넣기
			while(now <= input) {
				ans.add("+");
				s.push(now++);				
			}

			// 스택 top보다 입력이 작으면 수열 불가능
			if(input < s.peek()) {
				ans.clear();
				ans.add("NO");
				break;
			}
			
			// 스택top과 input이 같다면 pop
			if(input == s.peek()) {
				ans.add("-");
				
				s.pop();
			}
		}
		
		for(String str : ans) System.out.println(str);
		
	}

}
