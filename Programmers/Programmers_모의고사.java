import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        int[] idx = new int[3];
        int[] res = new int[3];
        
        for(int i=0; i<answers.length; i++){
            int ans = answers[i];
            idx[0] %= 5;
            idx[1] %= 8;
            idx[2] %= 10;
            
            if(first[idx[0]++] == ans) res[0]++;
            if(second[idx[1]++] == ans) res[1]++;
            if(third[idx[2]++] == ans) res[2]++;
            
        }
        
        int tmpRes = Math.max(res[0], Math.max(res[1], res[2]));
        
        for(int i=0; i<3; i++){
            if(tmpRes == res[i]) answer.add(i+1);
        }
        
        int[] returnArr = new int[answer.size()];
        
        for(int i=0; i<returnArr.length; i++){
            returnArr[i] = answer.get(i);
        }
        
        return returnArr;
    }
}