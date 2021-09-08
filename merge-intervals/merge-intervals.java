class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        
        LinkedList<int[]> st = new LinkedList<>();
        
        for(int []a : intervals) {
            int minStartTime = a[0];
            int maxEndTime = a[1];
            
            while(st.size() != 0 && st.getFirst()[1] >= a[0]) {
                minStartTime = st.getFirst()[0];
                maxEndTime = Math.max(st.getFirst()[1], maxEndTime);
                st.removeFirst();
            }
            
            st.addFirst(new int[] {minStartTime, maxEndTime});
        }
        
        int[][] ans = new int[st.size()][2];    
        int c = 0;
        while(st.size() != 0) {
            ans[c][0] = st.getFirst()[0];
            ans[c][1] = st.getFirst()[1];
            c++;
            st.removeFirst();
        }
        
        return ans;
    }
}