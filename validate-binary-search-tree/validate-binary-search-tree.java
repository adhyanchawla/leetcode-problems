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
    
    static TreeNode prev;
    public boolean helper(TreeNode root) {
        if(root == null) return true;
        
        boolean lans = helper(root.left);
        if(!lans) return false;
        
        if(prev != null && prev.val >= root.val) {
            return false;
        } 
        
        prev = root;
        
        boolean rans = helper(root.right);
        if(!rans) return false;
        
        return true;
    }
    
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return helper(root);
    }
}