class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return nums.length;
        
        HashMap<Integer, Boolean> hs = new HashMap<>();
        
        for(int ele : nums)
        {
            hs.put(ele, true);
        }
        
        for(int ele : nums)
        {
            if(hs.containsKey(ele-1))
            {
                hs.put(ele, false);
            }
        }
        
        int mst = -1;
        int ml = -1;
        for(int ele : nums)
        {
            if(hs.get(ele))
            {
                int len = 0;
                while(hs.containsKey(ele + len))
                {
                    len++;
                }
                
                if(len > ml)
                {
                    ml = len;
                    mst = ele;
                }
            }
        }
        
        return ml;
        
    }
}