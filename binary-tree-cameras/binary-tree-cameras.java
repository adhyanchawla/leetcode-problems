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
    
    public int cameras(TreeNode root) {
        if(root == null) return 2;
        
        int lc = cameras(root.left);
        int rc = cameras(root.right);
        
        if(lc == 0 || rc == 0) {
            cams++;
            return 1;
        } else if(lc == 1 || rc == 1) {
            return 2;
        } else {
            return 0;
        }
        
    }
    
    static int cams;
    public int minCameraCover(TreeNode root) {
        cams = 0;
        int state = cameras(root);
        if(state == 0) cams++;
        return cams;
    }
}