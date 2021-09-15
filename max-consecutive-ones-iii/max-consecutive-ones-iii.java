class Solution {
    public int longestOnes(int[] nums, int k) {
        
        // if(k )
        
        int i = -1, j = -1;

        int ans = 0;
        int cz = 0;


        while(i < nums.length -1) {
            while(i < nums.length - 1) {
                i++;

                if(nums[i] == 0){
                    cz++;
                    //i++;
                } 

                if(cz == k + 1) {
                    break;
                } else if(cz <= k){
                    int len = i - j;
                    if(len > ans) {
                        ans = len;
                    }
                }
            }
            while(j < i) {
                j++;

                if(nums[j] == 0) {
                    cz--;
                    break;
                }
            }
        }
         return ans;
    }
}