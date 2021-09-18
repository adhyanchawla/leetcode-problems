class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        long num = (long)numerator;
        long den = (long)denominator;
        
        if(num == 0) {
            return "0";
        }
        
        boolean isneg = false;
        boolean isden = false;
        if(num < 0) {
            num = -num;
            isneg = true;
        }
        
        if(den < 0) {
            den = -den;
            isden = true;
        }
        
        
        long q = num / den;
        long rem = num % den;
        
        String p1 = "";
        if((!isneg && isden) || (isneg && !isden)) {
            p1 = "-" + q;
        } else {
            p1 = q + "";
        }
    
        String p2 = "";
        
        //rem vs pos
        HashMap<Long, Integer> map = new HashMap<>();
        
        if(rem == 0) {
            
            return p1;
        } else {
            while(rem != 0) {
                if(map.containsKey(rem)) {
                    int pos = map.get(rem);
                    p2 = p2.substring(0, pos) + "(" + p2.substring(pos) + ")";
                    break;
                }
                map.put(rem, p2.length());
                num = rem * 10;
                q = num / den;
                p2 += q;
                rem = num % den;
            }
        }
        
        // if(isneg) {
        //     return "-" + p1 + "." + p2;
        // }
        
        return p1 + "." + p2;
    }
}