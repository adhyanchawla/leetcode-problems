class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int ps = 0;
        int ans = 0;
        
        map.put(0, 1);
        
        for(int i = 0; i < nums.length; i++) {
            
            ps += nums[i];
            
            if(map.containsKey(ps - k)) {
                ans += map.get(ps - k);
            }
            
            if(!map.containsKey(ps)) {
                map.put(ps, 1);
            } else {
                map.put(ps, map.get(ps) + 1);
            }
        }
        return ans;
    }
}