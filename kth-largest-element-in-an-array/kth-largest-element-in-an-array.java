class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(k <= 0 || k > nums.length) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        
        for(int i = k; i < nums.length; i++) {
            if(pq.peek() < nums[i]) {
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}