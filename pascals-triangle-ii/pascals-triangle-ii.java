class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Long>> ans = new ArrayList<>();
        long ncr = 1;
        for(int i = 0; i <= rowIndex; i++) {
            List<Long> res = new ArrayList<>();
            ncr = 1;
            for(int j = 0; j <= i; j++) {
                res.add(ncr);
                long ncrp1 = ((ncr) * (i - j)) / (j + 1);
                ncr = ncrp1;    
            }
            ans.add(res);
        }
        
        List<Integer> fans = new ArrayList<>();
        int mod = (int)1e9;
        for(long ele : ans.get(rowIndex)) {
            fans.add((int)((ele)));
        }
        
        return fans;
    }
}