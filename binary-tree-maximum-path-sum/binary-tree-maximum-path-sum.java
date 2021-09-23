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
    
    public int max(int...arr) {
        int omax = -(int)1e9;
        for(int ele : arr) {
            omax = Math.max(omax, ele);
        }
        return omax;
    }
    
    public int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        else if(root.left == null && root.right == null) {
            n2nmps = max(root.val, n2nmps);
            return root.val;
        }
        
        int lans = helper(root.left);
        int rans = helper(root.right);
        
        int f1 = lans + root.val;
        int f2 = rans + root.val;
        int f3 = lans + root.val + rans;
        int f4 = root.val;
        
        int r2nmps = max(f1, f2, f4);
        n2nmps = max(n2nmps, f1, f2, f3, f4, f1 + f2 - f4);
        
        return r2nmps;
    }
    
    
    static int n2nmps;
    public int maxPathSum(TreeNode root) {
        if(root.left == null && root.right == null) return root.val;
        
        n2nmps = -(int)1e9;
        int ans = helper(root);
        return Math.max(ans, n2nmps);
    }
}