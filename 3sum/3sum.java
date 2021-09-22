class Solution {
    
    public List<List<Integer>> twoSum(int[] arr, int target, int i, int j) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(i == arr.length) return ans;
        int prev = -(int)1e9;
        int next = -(int)1e9;
        while(i < j) {
            if(arr[i] + arr[j] == target) {
                if(prev != arr[i] && next != arr[j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[j]);
                    ans.add(list);
                    prev = arr[i];
                    next = arr[j];
                    i++;
                    j--;   
                } else {
                    i++;
                    j--;
                }
            } else if(arr[i] + arr[j] < target) {
                i++;
            } else if(arr[i] + arr[j] > target){
                j--;
            }
            
        }
        return ans;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {

        
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums.length <= 2) return res;
        
        Arrays.sort(nums);
        int target = 0;
        int prev = -(int)1e9;
        for(int i = 0; i < nums.length; i++) {
            int fele = nums[i];
            List<List<Integer>> ans = twoSum(nums, target - fele, i + 1, nums.length - 1);

            if(fele != prev && ans.size() > 0) {
                for(List<Integer> list : ans) {
                    List<Integer> myAns = new ArrayList<>();
                    myAns.add(fele);
                    for(int ele : list) {
                        myAns.add(ele);
                    }
                    res.add(myAns);
                }
            }
            
            prev = fele;
        }
        
        return res;
    }
}