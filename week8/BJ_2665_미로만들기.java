package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 	map을 만들텐데 좌표마다의 depth를 구해서 dp? 메모제이션? 느낌으로 풀기
 	-> dfs든 bfs든 완탐도 써야됨
 	
 	40분 걸림
*/

public class BJ_2665_미로만들기 {
	
	static class Pos{
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N;
	static int[][] map, dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		// 부순 벽의 수를 저장해 놓은 배열
		dp = new int[N][N];
		
		for(int i = 0 ; i < N; i++) {
			String input = br.readLine();
			for(int j = 0 ; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		// dp맵 전부 max값으로 채우기
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N; j++) {
				dp[i][j] = 987654321;
			}
		}
		dp[0][0] = 0;
		bfs();
		System.out.println(dp[N-1][N-1]);
	}
	
	
	static void bfs() {
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
//		boolean[][] visited = new boolean[N][N];
		
		Queue<Pos> q = new LinkedList();
		q.add(new Pos(0,0));
//		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			
			for(int d = 0 ; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				// 흰 벽인 경우
				if(map[nr][nc] == 1 && dp[nr][nc] > dp[now.r][now.c]) dp[nr][nc] = dp[now.r][now.c];
				// 검은 벽인 경우
				else if(map[nr][nc] == 0 && dp[nr][nc] > dp[now.r][now.c]) dp[nr][nc] = dp[now.r][now.c] + 1;
				else continue;
				q.add(new Pos(nr,nc));
			}
		}
		
	}
	
}

/*
static int getMin(int a, int b, int c, int d) {
	int min = 0;
	min = Math.min(a, Math.min(b, Math.min(c, d)));
	return min;
}

dp[1][1] = 0;
for(int i = 1; i <= N ; i++) {
	for(int j = 1; j <= N ; j++) {
		// 처음 위치는 패스
		if(i == 1 && j == 1) continue;
		
		// 주변 방중에 가장 dp값이 작은 값, 즉 가장 적게 벽을 부순 값을 선택
		// 흰 방인 경우 - 벽 부수는 값을 추가하지 않아도 됨
		if(map[i][j] == 1) {
			dp[i][j] = getMin(dp[i-1][j], dp[i+1][j], dp[i][j-1], dp[i][j+1]);
		}
		// 검은 방인 경우 - 벽을 하나 더 부숴야함
		else {
			System.out.println(i + " " + j);
			dp[i][j] = getMin(dp[i-1][j], dp[i+1][j], dp[i][j-1], dp[i][j+1]) + 1;
		}
	}
}
*/