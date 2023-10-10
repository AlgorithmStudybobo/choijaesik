package pgs;

import java.util.*;
class News {
    public int solution(String str1, String str2) {
        int answer = 0;
        double dAns = 0;
        
        ArrayList<String> list1 = new ArrayList();
        ArrayList<String> list2 = new ArrayList();
        
        // 각 문자열들 2개씩 쪼개서 배열에 넣기(영문자만)
        for(int i = 0 ; i < str1.length() - 1; i++){
            // 두개 모두 영어면 리스트에 넣기
            if(checkEnglish(str1,i)) list1.add(str1.substring(i, i+2).toLowerCase());
        }
        
        for(int i = 0 ; i < str2.length() - 1; i++){
            if(checkEnglish(str2,i)) list2.add(str2.substring(i, i+2).toLowerCase());
        }
        
        double inter = 0, union = 0;
        
        // boolean[] check1 = new boolean[list1.size];
        boolean[] check2 = new boolean[list2.size()];
        
        for(int i = 0; i < list1.size(); i++){
            for(int j = 0 ; j < list2.size(); j++){
                // 같으면 교집합처리
                if(!check2[j] && list1.get(i).equals(list2.get(j))){
                    inter++;
                    check2[j] = true;
                    break;
                }
            }
        }
               
        union = list1.size() + list2.size() - inter;
        
        System.out.println(list1);
        System.out.println(list2);
        
        // 2 8 이 나와야되는데 4 6 이 나옴 -> inter 잘못나오는중
        System.out.println(inter + " " + union); 
        
        dAns = inter / union;
        // 집합 두개가 모두 공집합일때
        if(list1.isEmpty() && list2.isEmpty()) return 65536;
        
        answer = (int)(dAns * 65536);
        return answer;
    }
    
    static boolean checkEnglish(String str,int start){
        if((('a' <= str.charAt(start) && str.charAt(start) <= 'z')
         || ('A' <= str.charAt(start) && str.charAt(start) <= 'Z'))
          &&
          (('a' <= str.charAt(start+1) && str.charAt(start+1) <= 'z')
         || ('A' <= str.charAt(start+1) && str.charAt(start+1) <= 'Z'))
          )
           return true;
        else return false;
    }
}