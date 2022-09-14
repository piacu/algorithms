class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        permutation(0, numbers, new boolean[numbers.length], target);
        return answer;
    }
    public void permutation(int index, int[] nums, boolean[] v, int tgt){
        if(index == nums.length){
            int sum = 0;
            for(int i=0; i<v.length; i++){
                if(v[i]){
                    sum += nums[i];
                } else {
                    sum -= nums[i];
                }
            }
            if(sum == tgt){
                answer++;
            }
            return;
        }
        
        v[index] = true;
        permutation(index+1, nums, v, tgt);
        v[index] = false;
        permutation(index+1, nums, v, tgt);
        
    }
}