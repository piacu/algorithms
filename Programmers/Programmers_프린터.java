import java.util.*;

class Solution {
    class Print{
        int num;
        int loc;
        
        Print(int num, int loc){
            this.num = num;
            this.loc = loc;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Print> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<priorities.length; i++){
            q.add(new Print(priorities[i], i));
            list.add(priorities[i]);
        }
        
        list.sort(Comparator.reverseOrder());
        
        while(true){
            Print now = q.poll();
            
            if(now.num == list.get(answer)){
                answer++;
                if(now.loc == location) return answer;
            } else {
                q.add(now);
            }
        }
        
    }
}