class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int ele : nums){
            sum += ele;
        }
        
        if(k <= 0 || sum % k != 0) return false;
        
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, visited, 0, k, 0, 0, sum/k);
        
    }
    
    public boolean canPartition(int[] nums, boolean[] visited, int si, int k, int curSum, int curNum, int target) {
        if(k == 1) return true;
        if(curSum == target && curNum > 0) return canPartition(nums, visited, 0, k - 1, 0, 0, target);
        
        for(int i = si; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(canPartition(nums, visited, i + 1, k, curSum + nums[i], curNum++, target)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
    
//     public boolean canPartitionKSubsets(int[] nums, int k) {
//         int sum = 0;
//         for(int num:nums)sum += num;
//         if(k <= 0 || sum%k != 0)return false;
//         int[] visited = new int[nums.length];
//         return canPartition(nums, visited, 0, k, 0, 0, sum/k);
//     }
    
//     public boolean canPartition(int[] nums, int[] visited, int start_index, int k, int cur_sum, int cur_num, int target){
//         if(k==1)return true;
//         if(cur_sum == target && cur_num>0)return canPartition(nums, visited, 0, k-1, 0, 0, target);
//         for(int i = start_index; i<nums.length; i++){
//             if(visited[i] == 0){
//                 visited[i] = 1;
//                 if(canPartition(nums, visited, i+1, k, cur_sum + nums[i], cur_num++, target))return true;
//                 visited[i] = 0;
//             }
//         }
//         return false;
//     }
}