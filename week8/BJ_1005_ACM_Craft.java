import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1005_ACM_Craft {

	static int[] inDegree, d;
	static int goal, n, k;
	static ArrayList<Integer>[] list;
	
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
            
            // 진입차수 체크배열
            inDegree = new int[n+1];
            
            // 인접리스트 - 연결시켜주기
            list = new ArrayList[n+1];
            for(int i = 1 ; i <= n ; i++) list[i] = new ArrayList<Integer>();
            for(int i = 0 ; i < k ; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list[from].add(to);
                inDegree[to]++;
            }
            
            goal = Integer.parseInt(br.readLine());
            sol();
            System.out.println(sum[goal]);
        }
    }
    
    static int[] sum;
    static void sol() {
    	// 진입차수 0인 노드들 큐에 넣기
    	Queue<Integer> q = new LinkedList<Integer>();
    	sum = new int[n+1];
    	
        for(int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) {
            	q.add(i);
            }
        }
    	
        // 각 노드별 누적 시간을 저장하는 배열
        sum = Arrays.copyOfRange(d, 0, d.length);
    	while(!q.isEmpty()) {
            
    		int nowNode = q.poll();
            for(int to : list[nowNode]) {
            	sum[to] = Math.max(sum[to], sum[nowNode] + d[to]);
        		inDegree[to]--;
        		if(inDegree[to] == 0) {
        			q.add(to);
        		}
        	}
        }
    }
}
