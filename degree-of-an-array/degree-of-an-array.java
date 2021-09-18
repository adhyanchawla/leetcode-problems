class Solution {
    public int findShortestSubArray(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> fo = new HashMap<>(); //last idx
        HashMap<Integer, Integer> lo = new HashMap<>(); //first idx
        
        for(int ele : arr) {
            int nf = freq.getOrDefault(ele, 0) + 1;
            freq.put(ele, nf);
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(!lo.containsKey(arr[i])) {
                lo.put(arr[i], i);
            }
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(!fo.containsKey(arr[i])) {
                fo.put(arr[i], i);
            } else {
                fo.put(arr[i], i);
            }
        }
        
        int max = 0;
        for(int ele : freq.keySet()) {
            if(freq.get(ele) > max) {
                max = freq.get(ele);
            }
        }
        
        int len = (int)1e9;
        int of = 0;
        int ol = 0;
        int e = 0;
        for(int ele : lo.keySet()) {
            if(freq.get(ele) == max) {
                int si = lo.get(ele);
                int li = fo.get(ele);
                if(len > li - si) {
                    len = li - si;
                    of = si;
                    ol = li;
                    e = ele;
                }
            }
        }
        
        // System.out.println(e);
        // System.out.println(of);
        // System.out.println(ol);
        
        return len + 1;
    }
}