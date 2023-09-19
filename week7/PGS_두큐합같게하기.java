import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        Queue <Integer> q1 = new LinkedList();
        Queue <Integer> q2 = new LinkedList();
        // 큐에 넣어주기
        for(int i = 0 ; i < queue1.length; i++) q1.add(queue1[i]);
        for(int i = 0 ; i < queue2.length; i++) q2.add(queue2[i]);
        
        int cnt = 0;
        int maxCnt = q1.size() + q2.size();      
        // 각 큐들의 요소 합 구하기
        long sum1 = 0, sum2 = 0;
        for(int i = 0 ; i < q1.size(); i++){
            sum1 += q1.peek();
            q1.add(q1.poll());

        }

        for(int i = 0 ; i < q2.size(); i++){
            sum2 += q2.peek();
            q2.add(q2.poll());
        }
        
        while(cnt++ < maxCnt * 3){
            // 값이 같아지면 리턴
            if(sum1 == sum2) return cnt-1;
            
             // 배열 요소들의 합이 반대쪽보다 크면 반대쪽으로 넘겨주기
            int now = 0;
            if(sum1 > sum2){
                now = q1.poll();
                sum1 -= now;
                sum2 += now;
                q2.add(now);
            } else{
                now = q2.poll();
                sum2 -= now;
                sum1 += now;
                q1.add(now); 
            }
        }
        
        // 합이 같지 못하는 경우 : 두 배열의 길이보다 많이 진행 됐을경우
        if(cnt == maxCnt) return -1;
         
        return answer;
    }
}