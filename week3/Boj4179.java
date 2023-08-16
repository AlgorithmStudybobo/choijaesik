package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class XY {
	int x;
	int y;
	
	public XY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}  	

	public boolean find(int x, int y) {
		if(this.x == x && this.y == y) return true;
		return false;
	}
}

public class Boj4179 {

	/*
	 * 시작 : 8/9 10:30 - 11:00
	 * 1) 지훈이 이동 -> 불 확산 인데 모든 상황 변화마다 map을 갱신시켜줘야함 -> map 갱신 어려움
	 * 
	 * 8/11 9:30 - 12:00
	 * 2) bfs로 J, F로 그냥 다 채우면서 F로는 벽 빼고 다 밀어버리기
	 * 
	*/
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int r,c;
    static char[][] map;
	static ArrayList<XY> xy;
	static int cnt;
	static String ans = "100000000";
    
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		xy = new ArrayList<>();
		
		int startJR = 0, startJC = 0;
		for(int i = 0 ; i < r; i++) {
			String input = br.readLine();
			for(int j = 0 ; j < c; j++) {
				map[i][j] = input.charAt(j);
				// 지훈이 초기 위치 저장
				if(map[i][j] == 'J') {
					startJR = i;
					startJC = j;
				}
				else if(map[i][j] == 'F') {
					xy.add(new XY(i,j));
				}
			}
		}
		
		bfs(startJR, startJC);
		System.out.println(ans);
    }
	
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static void bfs(int sjr, int sjc) {
    	
    	Queue<XY> qJ = new LinkedList<XY>();
    	Queue<XY> qF = new LinkedList<XY>();
    	// q에 지훈이 초기 좌표 저장
    	qJ.add(new XY(sjr,sjc));
    	    	
    	for(int i = 0 ; i < xy.size(); i++) {
    		qF.add(xy.get(i));
    	}
 	
    	while(!qJ.isEmpty()) {
    		cnt++;			
    		
			int jSize = qJ.size();
			for(int i = 0 ; i < jSize; i++) {
				
				XY now = qJ.poll();
				// 지훈이가 이미 방문한곳은 맵 바꿔주기
				map[now.getX()][now.getY()] = 'X';
				
				// 지훈이의 다음 좌표
				for(int d = 0 ; d < dx.length; d++) {
					int nx = now.getX() + dx[d];
					int ny = now.getY() + dy[d];
					
					// 지훈이가 좌표 밖으로 나가면 끝
					if(nx < 0 || nx >= r || ny < 0 || ny >= c) {
						ans = Integer.toString(Math.min(cnt, Integer.parseInt(ans)));
						return;
					} 
					
					// 다음 좌표가 . 이 아니면 이동 불가
					if(map[nx][ny] != '.') continue;
					
					// 이동할 수 있는 곳이면 q에 입력
					qJ.add(new XY(nx,ny));
					map[nx][ny] = 'J';					
				}			
			}
    		
//			System.out.print("qJ before : ");
//			for(XY i : qJ) System.out.print(i.getX() + "," + i.getY() + " ");
//			System.out.println();
//			
//    		for(int i = 0 ; i < r; i++) {
//        		for(int j = 0 ; j < c; j++) {
//            		System.out.print(map[i][j] + " ");
//            	}
//        		System.out.println();
//        	}
//    		System.out.println();
    		
    		// 불 전파
    		int fSize = qF.size();
    		for(int i = 0 ; i < fSize; i++) {		
    			XY nowFire = qF.poll();
    			for(int d = 0 ; d < dx.length; d++) {
    				
    				int nx = nowFire.getX() + dx[d];
        			int ny = nowFire.getY() + dy[d];
        			   			
        			if(nx < 0 || nx >= r || ny < 0 || ny >= c || map[nx][ny] == '#' ||  map[nx][ny] == 'F') continue;
        			       			
        			qF.add(new XY(nx,ny));
        			map[nx][ny] = 'F';
    			}    			
    		}	
    		
    		// qJ 큐 돌면서 그 좌표가 J가 아닌 다른걸로 바뀌었으면 poll해주기
    		jSize = qJ.size();
    		for(int i = 0 ; i < jSize; i++) {
    			if(map[qJ.peek().getX()][qJ.peek().getY()] != 'J') {
//    				System.out.println("조건 인식"); 
    				qJ.poll();
    			}
    			else qJ.add(qJ.poll());
    			
    		}
  		
//    		System.out.print("qJ after : ");
//			for(XY i : qJ) System.out.print(i.getX() + "," + i.getY() + " ");
//			System.out.println();
//    		
//    		for(int i = 0 ; i < r; i++) {
//        		for(int j = 0 ; j < c; j++) {
//            		System.out.print(map[i][j] + " ");
//            	}
//        		System.out.println();
//        	}
    	}
    	
    	// 큐를 다 돌았는데도 return이 안됐으면 탈출 불가
    	ans = "IMPOSSIBLE";
    	return;
    }
}

