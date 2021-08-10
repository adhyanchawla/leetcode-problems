class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        return targetSum(nums, 0, target, 0);
    }
    
    public int targetSum(int[] nums, int idx, int target, int sum){
        if(idx == nums.length){
            if(target == sum){
                return 1;
            }
            return 0;
        }
        
        int count = 0;
        count += targetSum(nums, idx + 1, target, sum + nums[idx]);
        count += targetSum(nums, idx + 1, target, sum - nums[idx]);
        
        return count;
    }
}