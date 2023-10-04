package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1005_ACM_Craft {
	
	static int[] inDegree, d;
	static int goal, n, k;
	static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            
            // 각 건물당 걸리는 시간
            st = new StringTokenizer(br.readLine());
            d = new int[n+1];
            for(int i = 1; i <= n; i++) d[i] = Integer.parseInt(st.nextToken());
            
            // 인접행렬 - 연결시켜주기
            map = new int[n+1][n+1];
            for(int i = 0 ; i < k ; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                map[from][to] = map[to][from] = 1;
            }
            
            goal = Integer.parseInt(br.readLine());
            ans = 0;
            beforeNode(goal);
            
        }
    }
    
    static int ans, max;
    static void beforeNode(int node) {
    	int max = 0;
    	for(int i = 1; i <= n ; i++) {
    		// 연결 되어있으면 재귀
    		if(map[node][i] == 1) {
    			beforeNode(i);
    			max = Math.max(max, d[i]);
    		}
    	} 
    }
}