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
    
    public static class Pair {
        int i;
        int e;
        
        Pair(int i, int e) {
            this.i = i;
            this.e = e;
        }
    }
    public Pair helper(TreeNode root) {
        if(root == null) return new Pair(0, 0);
        
        Pair lp = helper(root.left);
        Pair rp = helper(root.right);
        
        int inc = root.val + lp.e + rp.e;
        int exc = Math.max(lp.i, lp.e) + Math.max(rp.i, rp.e);
        Pair mp = new Pair(inc, exc);
        
        return mp;
            
    }
    
    public int rob(TreeNode root) {
        Pair h = helper(root);
        return Math.max(h.i, h.e);
    }
}