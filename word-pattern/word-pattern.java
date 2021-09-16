class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        
        if(pattern.length() != strs.length) return false;
        
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        
        for(int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String s2 = strs[i];
            
            if(!map.containsKey(ch)) {
                
                if(hs.contains(s2)) {
                    return false;
                }
                
                map.put(ch, s2);
                hs.add(s2);
            } 
            
            else{
                String s1 = map.get(ch);
                if(!s1.equals(s2)) {
                    return false;
                }  
                
            }
        }
        
        return true;
        
    }
}