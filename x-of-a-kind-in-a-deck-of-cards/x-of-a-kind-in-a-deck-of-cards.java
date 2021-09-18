class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length <= 1) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int ele : deck) {
            int nf = map.getOrDefault(ele, 0) + 1;
            map.put(ele, nf);
        }
        
        int ans = 0;
        for(int ele : map.keySet()) {
            ans = gcd(ans, map.get(ele));
        }
        
        System.out.println(ans);
        
        
        
        // for(int ele : map.keySet()) {
        //     if(map.get(ele) % min != 0) {
        //         return false;
        //     }
        // }
        
        return ans > 1;
    }
    
    public int gcd(int a, int b) {
        if(a == 0) {
            return b;
        } else if(b == 0) {
            return a;
        }
        
        int divisor = a;
        int dividend = b;
        
        while(dividend % divisor != 0) {
            int q = dividend / divisor;
            int rem = dividend % divisor;
            
            dividend = divisor;
            divisor = rem;
        }
        
        return divisor;
    }
}