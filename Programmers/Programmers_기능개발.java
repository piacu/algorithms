import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        
        while(index < progresses.length){
            for(int i=index; i<progresses.length; i++){
                progresses[i] += speeds[i];
            }
            
            int count = 0;
            
            if(progresses[index] >= 100){
                for(int j=index; j<progresses.length; j++){
                    if(progresses[j] < 100) break;
                    
                    index++;
                    count++;
                }
                list.add(count);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();

    }
}