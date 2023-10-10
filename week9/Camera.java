package pgs;

class Camera {
    public int solution(int[][] routes) {
        int answer = 1;
        int carNum = routes.length;       
        
        // 나가는 순서가 빠른 순으로 정렬
        for(int i = 0 ; i < carNum - 1; i++){
            for(int j = i + 1; j < carNum; j++){
                if(routes[i][1] > routes[j][1]){
                    int tmp1 = routes[i][0];
                    routes[i][0] = routes[j][0];
                    routes[j][0] = tmp1;

                    int tmp2 = routes[i][1];
                    routes[i][1] = routes[j][1];
                    routes[j][1] = tmp2;
                }                
            }
        }
        
        int now = routes[0][1];
        for(int i = 0 ; i < carNum; i++){
            if(routes[i][0] > now){
                now = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}
