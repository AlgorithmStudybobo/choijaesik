package pgs;

import java.util.*;
class Orange {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        // 각 귤 사이즈마다 개수 저장
        int[] orangeSize = new int[10000001];
        
        for(int i = 0 ; i < tangerine.length; i++){
            orangeSize[tangerine[i]]++;
        }
        
        // 귤 개수 저장된순으로 정렬
        Arrays.sort(orangeSize);
        
        for(int i = orangeSize.length-1; i >= 0 ; i--){
            if(k <= 0) break;
            
            k -= orangeSize[i];
            answer++;
        }
        
        return answer;
    }
}
