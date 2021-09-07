class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Arrays.sort(boxTypes, (a, b) -> {
            if(b[1] != a[1])
            return b[1] - a[1];
            else return b[0] - a[0];
        });
        
        int maxLimitSize = 0;
        int maxProfit = 0;
        for(int i = 0; i < boxTypes.length; i++) {
            if(maxLimitSize + boxTypes[i][0] < truckSize) {
                maxLimitSize += boxTypes[i][0];
                maxProfit += boxTypes[i][0] * boxTypes[i][1];
            } else if(boxTypes[i][0] >= truckSize - maxLimitSize) {
                int remaining = truckSize - maxLimitSize;
                if(remaining > 0 && boxTypes[i][0] >= remaining) {
                    maxLimitSize += remaining;
                    maxProfit += remaining * boxTypes[i][1];
                }  
            }
        }
        return maxProfit;
    }
}