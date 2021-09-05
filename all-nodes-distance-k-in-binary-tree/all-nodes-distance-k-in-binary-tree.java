/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public ArrayList<TreeNode> rootToNode(TreeNode root, int val)
    {
        if(root == null)
            return new ArrayList<>();
        if(root.val == val)
        {
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(root);
            return base;
        }
        
        ArrayList<TreeNode> lans = rootToNode(root.left, val);
        if(lans.size() > 0){
            lans.add(root);
            return lans;
        }
        
        ArrayList<TreeNode> rans = rootToNode(root.right, val);
        if(rans.size() > 0){
            rans.add(root);
            return rans;
        }
        
        return new ArrayList<>();
    }
    
    public void kDistanceDown(TreeNode root, int k, TreeNode blocker, List<Integer> ans){
        if(root == null || root == blocker || k < 0)
            return;
        if(k == 0){
            ans.add(root.val);
            return;
        }
        
        kDistanceDown(root.left, k-1, blocker, ans);
        kDistanceDown(root.right, k-1, blocker, ans);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<TreeNode> list = rootToNode(root, target.val);   
        
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < list.size(); i++)
        {
            kDistanceDown(list.get(i), k - i, i-1 >= 0 ? list.get(i-1) : null, ans);
        }
        
        return ans;
    }
}