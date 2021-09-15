class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int ans = 0;
        int i = 0;
        
        while(i < nums.length) {
            int count = 0;
            while(i < nums.length && nums[i++] == 1) {
                count++;
            }    
            
            if(ans < count) {
                ans = count;
            }
        }
        
     return ans;   
    }
}