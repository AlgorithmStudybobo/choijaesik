import java.util.ArrayList;
import java.util.Arrays;

/*
 * 걸린시간 : 3시간이상
 *  
*/
class Solution {
	static int[] numbers;
    static int[] salePer = {10,20,30,40};
    static int size;
    
    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        size = emoticons.length;
        numbers = new int[size];
        // 할인율에 대한 모든 순열 구함
        perm(0);

//        for(int i = 0 ; i < sale.size(); i++) {
//        	System.out.println(Arrays.toString(sale.get(i)));
//        }
        
        // 각 사용자별로 플러스 가입 및 이모티콘 구매 현황 구하기
        // 서비스 가입자수와 이모티콘 매출액
        int emoPlus = 0 , sumPrice = 0;
        int emoPlusNow = 0, sumPriceNow = 0, userBuy = 0;
        // 이모티콘 할인 상태마다
        for(int i = 0 ; i < sale.size(); i++){      
            emoPlusNow = 0;
            sumPriceNow = 0;
            // 유저마다
			for(int j = 0 ; j < users.length; j++){
                userBuy = 0;
                // 각 이모티콘마다
                for(int k = 0 ; k < sale.get(i).length; k++){
                    // 유저가 원하는 할인율보다 높다면 이모티콘 구매
                    if(users[j][0] <= sale.get(i)[k]){
                        userBuy += emoticons[k] - (emoticons[k] / 100 * sale.get(i)[k]);
                    }
                }
//                System.out.println("할인율 : " + sale.get(i)[0] + "," + sale.get(i)[1] + " 유저번호: " + (j+1) + " 사용가격 : " + userBuy);
                // 유저의 구매 비용이 '가격'보다 높으면 플러스 가입 o , 이모티콘 구매비용 0
                if(userBuy >= users[j][1]){
//                	System.out.println("count");
                    emoPlusNow++;
                }
                // 유저의 구매 비용이 '가격'보다 낮으면 플러스 가입 x , 이모티콘 구매비용 산만큼
                else{
                    sumPriceNow += userBuy;
                }
            }
            
//			System.out.println((i+1) + "번 할인율 플러스 가입수 : " + emoPlusNow + " 판매액 : " + sumPriceNow);
            // 우선순위1 : 플러스 가입자가 높은것
            if(emoPlus < emoPlusNow){
                emoPlus = emoPlusNow;
                sumPrice = sumPriceNow;
            }    
            else if(emoPlus == emoPlusNow){
            	// 우선순위2 : 판매액 늘리기
            	if(sumPrice < sumPriceNow){
            		sumPrice = sumPriceNow;
            	}
            }    
        }
        answer = new int[2];
        answer[0] = emoPlus;
        answer[1] = sumPrice;
        System.out.println(Arrays.toString(answer));
        return answer;
    }
    
    // 할인율의 경우의 수들이 담긴 배열의 리스트
    static ArrayList<int[]> sale = new ArrayList<>();
    // 중복순열
    static void perm(int cnt){
        if(cnt == size){
            sale.add(Arrays.copyOfRange(numbers,0,cnt));
            return;
        }
        
        for(int i = 0 ; i < salePer.length; i++){
            numbers[cnt] = salePer[i];            
            perm(cnt + 1);
        }
    }
 
    public static void main(String[] args) {
		int[][] users = {{40,10000},{25,10000}};
		int[] emoticons = {7000,9000};
		solution(users,emoticons);
	}
}