class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            } else {
                ArrayList<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i], list);
            }
        }
        
        int[] ans = new int[2];
        for(int ele : map.keySet()) {
            if(map.containsKey(target - ele)) {
                ArrayList<Integer> list = map.get(ele);
                if(target - ele == ele && list.size() == 2) {
                    ans[0] = list.get(0);
                    ans[1] = list.get(1);
                    return ans;
                } else {
                    ArrayList<Integer> list1 = map.get(target - ele);
                    int idx1 = list1.get(0);
                    int idx = list.get(0);
                    ans[0] = idx;
                    ans[1] = idx1;
                    return ans;
                }
            }
        }
        return ans;
    }
}