import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][n];
		int ans = 0;
		// 맵 생성
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[] check = new boolean[n];
		boolean flag = true;
		for(int i = 0 ; i < n ; i ++) {
			// 1열에서 시작
			// true : 가능, false : 불가
			flag = true;
			// 이미 경사로를 세웠는지 체크
			Arrays.fill(check, false);
			
			for(int j = 0; j < n - 1; j++) {
				// 지금 위치가 다음위치보다 1 낮을경우
				if(map[i][j] == map[i][j+1] - 1) {
					// 지금위치와 높이가 같은 경사들에 길이 L만큼 경사 놓기
					for(int nxt = j; nxt > j - l; nxt--) {
						if(j - l < -1 || map[i][nxt] != map[i][j] || check[nxt]) {
//							System.out.println(i + " " + j);
//							System.out.println(i + " " + j + " " +  map[i][nxt] + " " + map[i][j] + " " + !check[nxt]);
							flag = false;
							break;
						}
						// 세운 경사로 체크해주기
						else check[nxt] = true;
					}
				}
				// 지금 위치가 다음위치보다 1 높을경우
				else if(map[i][j] == map[i][j+1] + 1) {
					// 다음위치의 높이를 갖는 경사가 L보다 크거나 같은 길이만큼 있어야함
					for(int nxt = j + 1; nxt < j + l + 1; nxt++) {						
						if(j + l >= n || map[i][nxt] != map[i][j+1] || check[nxt]) {
							flag = false;
							break;
						}
						else check[nxt] = true;
					}
				}
				// 지금 위치와 다음위치가 같을 경우
				else if (map[i][j] == map[i][j+1]) {
//					System.out.println("same " + i + " " + j);
					continue;
				}
				// 차이가 1보다 클 경우
				else {
					flag = false;
					break;
				} 
			}	
			
			if(flag) ans++;
//			if(flag) System.out.println("row : " + i);
			
			// 1행에서 시작
			flag = true;
			Arrays.fill(check, false);
			int k = 0;
			for(k = 0; k < n - 1; k++) {
				if(map[k][i] == map[k+1][i] - 1) {
					for(int nxt = k; nxt > k-l; nxt--) {
						if(k - l < -1 || map[nxt][i] != map[k][i] || check[nxt] ) {
							flag = false;
							break;
						}
						else check[nxt] = true;
					}
				}
				else if(map[k][i] == map[k+1][i] + 1) {
					
					for(int nxt = k + 1; nxt < k + l + 1; nxt++) {
						if(k + l >= n || map[nxt][i] != map[k+1][i] || check[nxt]) {
							flag = false;
							break;
						}
						else check[nxt] = true;
					}
				}
				else if (map[k][i] == map[k+1][i]) continue;
				else {
					flag = false;
					break;
				} 
			}	
			
			if(flag) ans++;
//			if(flag) System.out.println("col : " + i);
		}
		
		System.out.println(ans);
	}

}
