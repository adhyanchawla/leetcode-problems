class Solution {
    
    public static void permute(int[] nums, List<Integer> ans, int count, List<List<Integer>> res)
    {
        if(count == nums.length)
        {
            List<Integer>base = new ArrayList<>(ans);
            res.add(base);
            return;
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] >= -10 && nums[i] <= 10)
            {
                int val = nums[i];
                nums[i] = -11;
                ans.add(val);
                permute(nums, ans, count + 1, res);
                
                ans.remove(ans.size() -1);
                nums[i] = val;
            }
        }
        
        
    }
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        permute(nums, ans, 0, res);
        return res;
        
    }
}