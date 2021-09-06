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
    TreeNode firstEle;
    TreeNode secEle;
    TreeNode prevEle;
    public void helper(TreeNode root) {
        
        if(root == null) return;
        
        helper(root.left);
        
        if(firstEle == null && prevEle != null && prevEle.val >= root.val) {
            firstEle = prevEle;
            //secEle = root;
        }
        
        if(firstEle != null && prevEle.val >= root.val) {
            secEle = root;
        }
        
        prevEle = root;
        
        helper(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        prevEle = null;
        firstEle = null;
        secEle = null;
        
        helper(root);   
        
        int val = firstEle.val;
        firstEle.val = secEle.val;
        secEle.val = val;
    }
    
    
}