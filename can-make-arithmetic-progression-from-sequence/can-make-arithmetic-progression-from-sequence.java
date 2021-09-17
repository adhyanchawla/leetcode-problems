class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int ele : arr) {
            hs.add(ele);
        }
        
        //if(hs.size() < arr.length) return false;
        
        if(hs.size() == 1) return true;
        
        int min = (int)1e9;
        
        for(int ele : arr) {
            min = Math.min(min, ele);
        }
        //System.out.println(min);
        
        int smin = (int)1e9;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != min) {
                if(smin > arr[i]) {
                    smin = arr[i];
                }
            }
        }
        
        //System.out.print(smin);
        
        int cd = smin - min;
        int c = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(!hs.contains(min + cd*c)) {
                return false;
            }
            c++;
        }
        
        return true;
    }
}