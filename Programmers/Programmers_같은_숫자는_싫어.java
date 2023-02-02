import java.util.*;

class Solution {
    public int[] solution(int []arr) {
        int[] tmpArr = new int[arr.length];
        int tmpNum = -1, index = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] != tmpNum){
                tmpArr[index++] = arr[i];
                tmpNum = arr[i];
            }
        }
        
        int[] answer = new int[index];
        System.arraycopy(tmpArr, 0, answer, 0, index);
        
        return answer;
    }
}