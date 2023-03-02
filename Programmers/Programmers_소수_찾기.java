import java.util.*;

class Solution {
    static Set<Integer> set;
    public int solution(String numbers) {
        set = new HashSet<>();
        char[] chs = numbers.toCharArray();
        
        for(int i=0; i<chs.length; i++){
            permutation(0, i+1, chs, new char[i+1], new boolean[chs.length]);  
        }
        
        return set.size();
    }
    public void permutation(int N, int max, char[] in, char[] out, boolean[] v){
        if(N == out.length){
            String str = "";
            for(int i=0; i<out.length; i++){
                str += out[i];
            }
            
            int num = Integer.parseInt(str);
            
            if(num<2) return;
            for(int i=2; i<num; i++){
                if(num % i == 0) return;
            }
            
            set.add(num);
            return;
        }
        
        for(int i=0; i<in.length; i++){
            if(!v[i]){
                v[i] = true;
                out[N] = in[i];
                permutation(N+1, max, in, out, v);
                v[i] = false;
            }
        }
    }
}