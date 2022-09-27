import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        for(int i=0; i<commands.length; i++){
            int[] tmpArr = new int[array.length];
            
            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                tmpArr[i] = commands[i][j];    
            }
            tmpArr = sort(tmpArr);
            System.out.println(tmpArr);
            answer[i] += tmpArr[commands[i][2] - 1];
        }
        
        return answer;
    }
    
    private int[] sort(int[] arr){
        int tmp = 0;
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}