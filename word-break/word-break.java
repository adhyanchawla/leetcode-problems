class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>(wordDict);
        HashSet<Integer> mem = new HashSet<>();
        return wb(s, hs, mem, 0);
    }
    
    public boolean wb(String s, HashSet<String> hs, HashSet<Integer> mem, int idx) {
        int l = s.length();
        if(idx == l)
            return true;
        
        if(mem.contains(idx)) return false;
        
        for(int i = idx + 1; i <= l; i++){
            String t = s.substring(idx, i);
            if(hs.contains(t)){
                if(wb(s, hs, mem, i)){
                    return true;
                } else{
                    mem.add(i);
                }
            }
        }
        mem.add(idx);
        
        return false;
    }
    
    // private boolean dfs(String s, int index, Set<String> dict, Set<Integer> set){
    //     // base case
    //     if(index == s.length()) return true;
    //     // check memory
    //     if(set.contains(index)) return false;
    //     // recursion
    //     for(int i = index+1;i <= s.length();i++){
    //         String t = s.substring(index, i);
    //         if(dict.contains(t))
    //             if(dfs(s, i, dict, set))
    //                 return true;
    //             else
    //                 set.add(i);
    //     }
    //     set.add(index);
    //     return false;
    // }
}