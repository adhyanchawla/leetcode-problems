class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        int[] ans = new int[m + n];
        
        int i = 0, j = 0;
        int k = 0;
        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                ans[k++] = nums1[i++];
            } else {
                ans[k++] = nums2[j++];
            }
        }
        
        if(i < nums1.length) {
            while(i < nums1.length && nums1[i] > 0) {
                ans[k++] = nums1[i++];
            }
        }
        
        if(j < nums2.length) {
            while(j < nums2.length) {
                ans[k++] = nums2[j++];
            }
        }
        
        for(int a = 0; a < m + n; a++) {
            nums1[a] = ans[a];
        }
    }
}