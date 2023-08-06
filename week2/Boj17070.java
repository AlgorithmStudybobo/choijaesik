import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 파이프 옮기기
 * 
 * 이차원 배열에서 목적지까지 가는것 이므로 dfs를 생각했고
 * 방향을 고려해서 상황별로 나눠서 구현함
*/
public class Boj17070 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] visited;
	static int n;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		// map 입력
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) visited[i][j] = true;
			}
		}
		
		dfs(1,0,1);
		System.out.println(ans);
	}
	
	// dir1 : 오른쪽 , dir2 : 오른쪽밑 대각선 , dir3 : 밑
	static void dfs(int dir, int r, int c) {
		
		// 목적지에 도달하면 정답 카운트
		if(r == n-1 && c == n-1) ans++;
		
		int[] dr = {0,1,1};
		int[] dc = {1,1,0};
		
		for(int i = 0 ; i < dr.length; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			
			// i=1(오른쪽 밑대각선) 일때 좌표들의 정보 추가 확인
			if(i == 1) if(nextR >= n || nextC >= n || nextR <= 0 || visited[nextR][nextC-1] || visited[nextR-1][nextC] || visited[nextR][nextC]) continue;

			// 범위 밖이면 패스
			if(nextR >= n || nextC >= n || visited[nextR][nextC]) continue;
			
			// 각 방향별 상황구현
			if(dir == 1) {				
				if(i == 0) dfs(1,nextR, nextC);
				else if(i == 1) dfs(2,nextR, nextC);
			}
			else if(dir == 2) {				
				if(i == 0) dfs(1,nextR, nextC);
				else if(i == 1) dfs(2,nextR, nextC);
				else dfs(3,nextR, nextC);
			}
			else {				
				if(i == 1) dfs(2,nextR, nextC);
				else if(i == 2) dfs(3,nextR, nextC);
			}
		}
		
		
	}

}
