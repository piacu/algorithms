import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int len = commands[i][1] - commands[i][0] + 1;
            int[] tmpArr = new int[len];

            for(int j=0; j<len; j++){
                tmpArr[j] = array[commands[i][0] - 1 + j];
            }

            tmpArr = sort(tmpArr);
            answer[i] = tmpArr[commands[i][2] - 1];
        }

        return answer;
    }

    private int[] sort(int[] arr){
        int tmp = 0;

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[i] < arr[j]){
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}