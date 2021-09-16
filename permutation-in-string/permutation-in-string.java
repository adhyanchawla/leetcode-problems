class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        
        HashMap<Character, Integer> map2 = new HashMap<>();
        HashMap<Character, Integer> map1 = new HashMap<>();
        
        int i = -1, j = -1;
        
        for(i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            int nf = map2.getOrDefault(ch, 0) + 1;
            map2.put(ch, nf);
        }
        
        for(i = 0; i < s1.length(); i++) {
            char ch = s2.charAt(i);
            int nf = map1.getOrDefault(ch, 0) + 1;
            map1.put(ch, nf);
        }
        
        if(map2.equals(map1)){
            return true;
        }
        
        i = s1.length() - 1;
        
        while(i < s2.length() - 1) {
            
            i++;
            
            char ch1 = s2.charAt(i);
            int nf = map1.getOrDefault(ch1, 0) + 1;
            map1.put(ch1, nf);
            
            j++;
            char ch2 = s2.charAt(j); 
            int f2 = map1.get(ch2);
            
            if(f2 == 1) {
                map1.remove(ch2);
            } else {
                map1.put(ch2, f2 - 1);
            }
            
            if(map1.equals(map2)){
                return true;
            }
            
        }
        
        return false;
        
    }
}