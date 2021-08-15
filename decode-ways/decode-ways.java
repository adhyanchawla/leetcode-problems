class Solution {
    public int numDecodings(String s) {
        
        int[] qb = new int[s.length()];
        Arrays.fill(qb, -1);
        int count = countEncodings(s, "", qb, 0);
        
        return count;
    }
    
    public int countEncodings(String ques, String ans, int[] qb, int p)
    {
        if(ques.length() == 0)
        {
            return 1;
        }
        
        int count = 0;
        if(qb[p] != -1)
        {
            return qb[p];
        }
        char ch = ques.charAt(0);
        int num = (int)(ch - '0');
        if(num != 0)
        {
            char c1 = (char)(num + 'a' - 1);
            count += countEncodings(ques.substring(1), ans + c1, qb, p+1);  
        }
        
        
        if(ques.length() > 1)
        {
            int num1 = num * 10 + (ques.charAt(1) - '0');
            if(num1 >= 10 && num1 <= 26)
            {
                char c2 = (char)(num1 + 'a' -1);
                count += countEncodings(ques.substring(2), ans + c2, qb, p+2);
            }
        }
        
        qb[p] = count;
        return count;
    }
}