class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n * (n+1) / 2];
        
        int[][] map = new int[1001][1001];        
        
        // dequeu로 풀기?
        
        // d - 0 : 왼아 , 1 : 오 , 2 : 왼위  
        int d = 0, val = 1, idx = n-1;
        // int last = n * (n+1) / 2
        int[] dr = {1,0,-1};
        int[] dc = {0,1,-1};
        int nr = 0 , nc = 0;
        
        // 처음 한번은 횟수 안빼고 돌려줘야함
        for(int i = 0 ; i < idx ; i++){          
            map[nr][nc] = val++;
            nr += dr[d];
            nc += dc[d];
        }
        d++;

        while(idx >= 0){
            for(int i = 0 ; i < idx ; i++){          
                map[nr][nc] = val++;
                nr += dr[d];
                nc += dc[d];
            }
            d = (d+1) % 3;
            idx--;
        }
        map[nr][nc] = val;
        
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i+1 ; j++){
                answer[cnt++] = map[i][j];
            }
        }
        
        return answer;
    }
}