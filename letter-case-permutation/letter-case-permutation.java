class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        letterPermutation(s, 0, ans, "");
        return ans;
    }
    
    public boolean isNum(char ch){
        if(ch - '0' >= 0 && ch - '0' <= 9)
            return true;
        else return false;
    }
    
    public void letterPermutation(String s, int idx, List<String> ans, String asf){
        if(idx >= s.length()) {
            ans.add(asf);
            return;
        }
        
        char ch = s.charAt(idx);
        if(isNum(ch)) {
            letterPermutation(s, idx + 1, ans, asf + ch);
            return;
        } else {
            letterPermutation(s, idx + 1, ans, asf + Character.toUpperCase(ch));
            letterPermutation(s, idx + 1, ans, asf + Character.toLowerCase(ch));
        }
    }
}