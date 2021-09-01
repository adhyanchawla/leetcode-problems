/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        while(q.size() != 0) {
            int sz = q.size();
            
            while(sz-->0) {
                
                if(sz == 0) {
                    ans.add(q.peek().val);
                }
                
                TreeNode rm = q.remove();
                
                if(rm.left != null) q.add(rm.left);
                if(rm.right != null) q.add(rm.right);
            }
            
            
        }
        
        return ans;
    }
}