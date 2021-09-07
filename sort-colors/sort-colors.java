class Solution {
    public void sortColors(int[] nums) {
        
        int prev = -1;
        int itr = 0;
        int itr1 = nums.length - 1;
        
        while(itr <= itr1) {
            
            if(nums[itr] == 0) {
                prev++;
                int temp = nums[prev];
                nums[prev] = nums[itr];
                nums[itr] = temp;
                itr++;
                
            } else if(nums[itr] == 2) {
                int temp = nums[itr1];
                nums[itr1] = nums[itr];
                nums[itr] = temp;
                itr1--;
            } else {
                itr++;
            }
            
        }
        
    }
}