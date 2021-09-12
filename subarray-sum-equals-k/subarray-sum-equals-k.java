class Solution {
    public int subarraySum(int[] nums, int k) {
        
        
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return result;
        // if(nums.length == 1 && nums[0] == k) return 1;
        // else if(nums.length == 1 && nums[0] != k) return 0;
        
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int ps = 0;
//         int count = 0;
        
//         map.put(0, 1);
        
//         for(int i = 0; i < nums.length; i++) 
//         {
//             ps += nums[i];
            
//             if(map.containsKey(ps - k)) {
//                 count += map.get(ps - k);

//             } else { 
//                 map.put(ps, map.getOrDefault(ps, 0) + 1);
//             }
//         }
        
//         return count;
    }
}