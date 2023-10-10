package pgs;

class Clean {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int row = wallpaper.length;
        int col = wallpaper[0].length();
        
        int minRow = 51, minCol = 51, maxRow = 0, maxCol = 0;
        for(int i = 0 ; i < row; i++){
            for(int j = 0 ; j < col ; j++){
                if(wallpaper[i].charAt(j) == '#'){
                    minRow = Math.min(minRow,i);
                    minCol = Math.min(minCol,j);
                }
            }
            
            for(int j = col-1 ; j >= 0 ; j--){
                if(wallpaper[i].charAt(j) == '#'){
                    maxRow = Math.max(maxRow,i);
                    maxCol = Math.max(maxCol,j);
                }
            }
        }
        
        answer[0] = minRow;
        answer[1] = minCol;
        answer[2] = maxRow + 1;
        answer[3] = maxCol + 1;
        
        return answer;
    }
}
