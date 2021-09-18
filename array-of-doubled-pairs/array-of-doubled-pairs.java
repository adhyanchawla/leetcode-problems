class Solution {
    public boolean canReorderDoubled(int[] arr) {
        if(arr.length % 2 != 0) return false;
        
        
        Integer[] arrI = new Integer[arr.length];
        
        for(int i = 0; i < arr.length; i++) {
            arrI[i] = new Integer(arr[i]);
        }
        
        Arrays.sort(arrI, (a, b) ->{
           return Math.abs(a) - Math.abs(b); 
        });
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(Integer ele : arrI) {
            int nf = map.getOrDefault(ele, 0) + 1;
            map.put(ele, nf);
        }
        
        for(int i = 0; i < arrI.length; i++) {
            int val = 2 * arrI[i];
            
            if(arrI[i] == 0) {
                if(map.get(arrI[i]) % 2 != 0) {
                    return false;
                }
                continue;
            }
            
            if(map.containsKey(arrI[i]) && map.get(arrI[i]) > 0) {
                int freq1 = map.getOrDefault(arrI[i], 0);
                int freq2 = map.getOrDefault(val, 0);

                if(freq2 == 0) {
                    return false;
                }

                if(freq1 == 1) {
                    map.remove(arrI[i]);
                } else {
                    map.put(arrI[i], freq1 - 1);
                }
                if(freq2 == 1) {
                    map.remove(val);
                } else {
                    map.put(val, freq2 - 1);
                }    
            }
            
            
            
        }
        
        return true;
    }
}