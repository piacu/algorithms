class Solution {
    public int solution(int[][] sizes) {
        
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        
        int xMax = 0, yMax = 0;
        for(int i=0; i<sizes.length; i++){
            xMax = Math.max(xMax, sizes[i][0]);
            yMax = Math.max(yMax, sizes[i][1]);
        }
        
        return xMax * yMax;
        
    }
}