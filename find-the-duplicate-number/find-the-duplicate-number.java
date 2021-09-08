class Solution {
    public int findDuplicate(int[] nums) {
        
        int[] sp = new int[nums.length + 1];
        
        for(int i = 1; i <= nums.length; i++) {
            int v = nums[i - 1];
            sp[v] += v;
        }
        
        for(int i = 1; i < sp.length; i++) {
            if(sp[i] > i){
                return i;
            }
        }
        return 0;
    }
}