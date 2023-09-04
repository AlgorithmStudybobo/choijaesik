package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BJ_15685_드래곤커브 {
	static class Dragon{
		int d, g;
		public Dragon( int d, int g) {
			super();
			this.d = d;
			this.g = g;
		}
	}
	
	static int N;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[102][102];
		
		// 드래곤 수만큼 진행
		while(n-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			map[y][x] = 1;
			if(g == 0) {
				map[y+dx[d]][x+dy[d]] = 1;
				continue;
			}
			curve(x, y, d, g);
		}
		int ans = 0;
		for(int i = 0 ; i <= 100; i++) {
			for(int j = 0 ; j <= 100; j++) {
				if(map[i][j] == 1 && map[i][j+1] == 1 && map[i+1][j] == 1 && map[i+1][j+1] == 1){
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
	
	// x가 열, y가 행 
	// 0 오, 1 위, 2 왼, 3아 
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static ArrayList<Dragon> dragons;
	static void curve(int y, int x, int d, int g) {
		// 각 세대별 드래곤을 담는 스택
		Stack<Dragon> s = new Stack<>();
		// 전체 드래곤 관리
		dragons = new ArrayList();
		dragons.add(new Dragon(d, 0));
		// 바로 다음점 체크
		x += dx[d];
		y += dy[d];
		map[x][y] = 1;
		d = (d+1) % 4;
		int cntGender = 1;
		while(cntGender <= g) {
			
			// 새로운 세대의 드래곤일때 이전 드래곤들 큐에 넣기
			for(int i = 0 ; i < dragons.size() ; i++) s.add(dragons.get(i));
			while(!s.isEmpty()) {
				Dragon now = s.pop();
				d = (now.d + 1) % 4;
				// 새로운 드래곤은 리스트에 추가
				dragons.add(new Dragon(d,cntGender));
				// 좌표 이동후 맵 1로 변경
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx < 0 || nx > 100 || ny < 0 || ny > 100) continue;
				x = nx;
				y = ny;
				map[x][y] = 1;
			}
			cntGender++;
		}
	}
}