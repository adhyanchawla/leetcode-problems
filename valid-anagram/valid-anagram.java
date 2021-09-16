class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        //HashMap<Character, Integer> map2 = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int freq = map1.getOrDefault(ch, 0) + 1;
            map1.put(ch, freq);
        }
        
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(!map1.containsKey(ch)) {
                return false;
            } else {
                int freq = map1.get(ch);
                if(freq == 1) {
                    map1.remove(ch);
                }
                else map1.put(ch, freq - 1);
            }
        }
        
        if(map1.size() > 0) {
            return false;
        } else {
            return true;
        }
        
    }
}