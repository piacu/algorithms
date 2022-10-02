import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNums = new String[numbers.length];
        
        for(int i=0; i<strNums.length; i++){
            strNums[i] = Integer.toString(numbers[i]);
        }
        
        // comparator 기본 사용법
        // Comparator<String> comp = (o1, o2) -> (o2 + o1).compareTo(o1 + o2);
        // Arrays.sort(strNums, comp);

        // lambda, comparator 사용법
        // Arrays.sort(strNums, new Comparator<String>() {
        //     @Override
        //     public int compare(String o1, String o2){
        //         return (o2 + o1).compareTo(o1 + o2);
        //     }
        // });

        // 람다식 사용
        Arrays.sort(strNums, (a, b) -> {
            return (b + a).compareTo(a + b);
            }
        );
        
        if(strNums[0].equals("0")) return "0";
        
        return String.join("", strNums);
    }
}