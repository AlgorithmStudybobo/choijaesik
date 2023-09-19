class Solution {
    static class City{
        String name;
        int rank;
        
        City(String name, int rank){
            this.name = name;
            this.rank = rank;
        }
        
    }
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        // 도시이름 전부 소문자로 바꾸기
        String[] citiesLower = new String[cities.length];
        
        for(int i = 0; i < cities.length; i++){
            citiesLower[i] = cities[i].toLowerCase();
        }
        
        // 캐시 사이즈 0일때
        if(cacheSize == 0){
            return cities.length * 5;
        }
        
            
        City[] cache = new City[cacheSize];

        for(int i = 0 ; i < cities.length; i++){
            int j = 0;

            for(j = 0 ; j < cacheSize; j++){

                // 넣으려는게 배열에 있을때 - 우선순위 갱신 후 + 1
                if(cache[j] != null && cache[j].name.equals(citiesLower[i])){
                    cache[j].rank = i;
                    answer += 1;
                    break;
                }
            }

            // 내가 지금 넣으려는게 배열에 없을 때
            if(j == cacheSize){
                int min = 987654321, idx = 0;
                // 가장 최근에 안쓴 캐쉬를 교체해주기
                for(int k = 0; k < cacheSize; k++){
                    if(cache[k] == null){
                        idx = k;
                        break;
                    }
                    if(min > cache[k].rank){
                        min = cache[k].rank;
                        idx = k;
                    }                
                }
                // 캐쉬에 넣어주고 + 5
                cache[idx] = new City(citiesLower[i], i);
                answer += 5;
            }
        }
        return answer;
    }
}