class Solution {    
    public static class Car{
        int in, out, time;        
        public Car(int in, int out, int time){
            this.in = in;
            this.out = out;
            this.time = time;
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        // cars : 자동차 입,출차, 누적시간 저장
        Car[] cars = new Car[10001];
        
        for(int i = 0 ; i < records.length; i++){
            
            int carNum = Integer.parseInt(records[i].substring(6,10));
            // 시간 전부 분으로 계산
            int nowTime = Integer.parseInt(records[i].substring(0,2)) * 60 +
                          Integer.parseInt(records[i].substring(3,5));
            
            // IN인 경우
            if(records[i].substring(11,records[i].length()).equals("IN")){
                // 입장 시간 입력해주기
                if(cars[carNum] == null){
                    cars[carNum] = new Car(nowTime,0,0);
                } else{
                    cars[carNum] = new Car(nowTime,0,cars[carNum].time);
                }
                
            }
            // OUT인 경우
            else if(records[i].substring(11,records[i].length()).equals("OUT")){
                // 이전 방문시간에서 빼서 누적시간에 더하고 출차 처리(입장시간 1440분) 해주기
                cars[carNum].time += nowTime - cars[carNum].in;
                cars[carNum].out = nowTime;
            }
        }
        
         int[] ans = new int[10001];
         int lastTime = 1439;
         int carCnt = 0;
         for(int i = 0 ; i < 10000; i++){
             double useTime = 0;
             // 차가 주차장 이용한적이 있을경우
             if(cars[i] != null){
                 // 차 개수 세기
                 carCnt++;
                 // 출차를 자동으로 한 경우(23:59분 출차)
                 if(cars[i].out == 0) useTime = cars[i].time + lastTime - cars[i].in;               
                 // 출차를 직접 한 경우
                 else useTime = cars[i].time;
         
                 // 요금 계산
                 // 기본시간 이하일 경우 기본요금
                 if(useTime <= fees[0]) ans[i] += fees[1];
                 else {
                     // 기본요금 + (내가 초과해서 쓴 시간)/단위시간 * 요금
                     // 올림 처리
                     if( (useTime - fees[0]) % fees[2] != 0) 
                         ans[i] += fees[1] + ((int)((useTime - fees[0]) / fees[2]) + 1) * fees[3];
                     else 
                         ans[i] += fees[1] + (int)((useTime - fees[0]) / fees[2]) * fees[3];
                 }
             }
         }
        
        
        int [] answer = new int[carCnt];
        int idx = 0;
        for(int i = 0 ; i < 10000; i++) {
             if(cars[i] != null) answer[idx++] = ans[i];
        }
       
        return answer;
    }
}