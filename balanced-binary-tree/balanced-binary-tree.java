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
    
    public class isBAL {
        int height;
        boolean isbal;
        
        isBAL(int height, boolean isbal) {
            this.height = height;
            this.isbal = isbal;
        }
    }
    
    public isBAL fun(TreeNode root) {
        if(root == null) return new isBAL(0, true);
        
        isBAL lp = fun(root.left);
        isBAL rp = fun(root.right);
        
        boolean isbal = lp.isbal && rp.isbal && Math.abs(lp.height - rp.height) <= 1;
        int height = Math.max(lp.height, rp.height) + 1;
        isBAL mp = new isBAL(height, isbal);
        
        return mp;
    }
    public boolean isBalanced(TreeNode root){
        isBAL b = fun(root);
        return b.isbal;
    }
}