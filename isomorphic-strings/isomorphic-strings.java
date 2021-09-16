class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if(!map.containsKey(ch1)) {
                if(hs.contains(ch2)) {
                    return false;
                }
                map.put(ch1, ch2);
                hs.add(ch2);
                
            } else {
                char c1 = map.get(ch1);
                if(c1 != ch2) {
                    return false;
                }
            }
        }
        
        return true;
    }
}