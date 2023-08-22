package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_17281_야구공 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int score = 0;
		int order = 1;
		// 이닝 수  만큼 게임
		for(int i = 0 ; i < n; i++) {
			// 선수 타순
			int[] player = new int[10];
			// 필드 정보
			boolean[] field = new boolean[5];
			// 정렬을 위한 pq
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 9; j++) {
				// 1번 선수는 4번 타자 고정
				// 나머지 선수는 정렬해서 입력
				if(j > 1) {
					int input = Integer.parseInt(st.nextToken());
					if(input == 0) continue;
					pq.add(input);
				}
				else player[4] = Integer.parseInt(st.nextToken());
			}
			
			// 4번타자 고정
			for(int j = 1; j <= 9; j++) {
				if(j == 4) continue;
				if(pq.isEmpty()) {
					player[j] = 0;
					continue;
				}
				player[j] = pq.poll();
			}
			
//			System.out.println(Arrays.toString(player));
			
			// 이닝마다 아웃 초기화
			int out = 0;
			while(out < 3) {
				// 3out이면 이닝 종료
				// 게임
				switch(player[order++]) {
				case 0 :
					out++;
					break;
				case 1 :
					for(int f = 1; f <= 3; f++) {
						// 주자가 있으면 다음 1개의 베이스로 밀기
						if(field[f]) {
							field[f] = false;
							
							// 1루타로 점수가 날 경우
							if(f + 1 > 3) {
								score++;
								continue;
							}
							field[f + 1] = true;
						}
					}
					field[1] = true;
					break;
				case 2 :
					for(int f = 1; f <= 3; f++) {
						// 주자가 있으면 다음 2개의 베이스로 밀기
						if(field[f]) {
							field[f] = false;
							
							// 2루타로 점수가 날 경우
							if(f + 2 > 3) {
								score++;
								continue;
							}
							field[f + 2] = true;
						}
					}
					field[2] = true;
					break;
				case 3 :
					for(int f = 1; f <= 3; f++) {
						// 주자가 있으면 다음 1개의 베이스로 밀기
						if(field[f]) {
							field[f] = false;
							
							// 3루타로 점수가 날 경우
							if(f + 3 > 3) {
								score++;
								continue;
							}
							field[f + 3] = true;
						}
					}
					field[3] = true;
					break;
				case 4 :
					// 주자 수만큼 +
					for(int f = 1; f <= 3; f++) {
						if(field[f]) {
							score++;
							field[f] = false;
						}
					}
					// 친 사람 점수도 +
					score++;
					break;
				}
				
				// 타순이 9가 넘으면 1로
				if(order > 9) order = 1;
			}
		}
		System.out.println(score);
	}

}
