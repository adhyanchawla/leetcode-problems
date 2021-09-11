class Solution {
    public boolean canArrange(int[] arr, int k) {
        if(arr.length % 2 == 1) return false;
        
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int mod = 0;
        for(int ele : arr) {
            if(ele < 0) {
                mod = ele % k;
                mod = mod + k;
                if(mod == k) {
                    mod = 0;
                }
            } else {
                mod = ele % k;
            }
            //System.out.print(mod + " ");
            if(hmap.containsKey(mod)) {
                hmap.put(mod, hmap.get(mod) + 1);
            } else {
                hmap.put(mod, 1);
            }
        }
        
        
        
        
        for(int rem : hmap.keySet()) {
            int freq = hmap.get(rem);
            
            if(rem == 0) {
                if(freq % 2 != 0){
                    return false;
                }
            } else if(k % 2 == 0 && rem == k / 2){
                if(freq % 2 != 0){
                    return false;
                }
            } else {
                if(!hmap.containsKey(k - rem)) {
                    return false;
                } else {
                    int freq1 = hmap.get(k - rem);
                    if(freq1 != freq) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}