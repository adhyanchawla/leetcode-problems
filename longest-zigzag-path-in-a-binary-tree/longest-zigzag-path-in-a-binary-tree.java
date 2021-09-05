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
    
    public class Pair {
        int lzzp;
        int rzzp;
        int mzzp;
        
        Pair(int lzzp, int rzzp,int mzzp) {
            this.lzzp = lzzp;
            this.rzzp = rzzp;
            this.mzzp = mzzp;
        }
    }
    
    public Pair MZP(TreeNode root) {
        if(root == null) return new Pair(-1, -1, 0);
        
        Pair lp = MZP(root.left);
        Pair rp = MZP(root.right);
        
        int lzzp = lp.rzzp + 1;
        int rzzp = rp.lzzp + 1;
        
        int mzzp = max(lp.mzzp, rp.mzzp, lzzp, rzzp);
        
        Pair mp = new Pair(lzzp, rzzp, mzzp);
        return mp;
    }
    
    public int max(int a, int b, int c, int d) {
        int c1 = Math.max(a, b);
        int c2 = Math.max(c, d);
        
        return Math.max(c1, c2);
    }
    
    public int longestZigZag(TreeNode root) {
        Pair p = MZP(root);
        return p.mzzp;
    }
}