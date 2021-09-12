class Solution {
    public int findMaxLength(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int ans = 0;
        int ps = 0;
        
        map.put(0, -1);
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                ps += -1;
            }
            else ps += nums[i];
            
            if(!map.containsKey(ps)) {
                map.put(ps, i);
            }
            else {
                int len = i - map.get(ps);
                if(len > ans) {
                    ans = len;
                }
            }
        }
        
        return ans;
        
    }
}