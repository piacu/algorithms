class Solution {
    boolean solution(String s) {
        int sLen = s.length();
        int check = 0;
        
        for(int i=0; i<sLen; i++){
            if(check < 0) return false;
            
            if(s.charAt(i) == '(') {
                check++;
            } else if(s.charAt(i) == ')') {
                check--;
            }
        }

        return check == 0 ? true : false;
    }
}