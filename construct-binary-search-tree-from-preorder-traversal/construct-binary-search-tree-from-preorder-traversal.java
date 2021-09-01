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
    
    public TreeNode buildTree(int[] preorder, int lr, int rr) {
        if(idx >= preorder.length || preorder[idx] < lr || preorder[idx] > rr) return null;
        else {
            TreeNode root = new TreeNode(preorder[idx++]);
            root.left = buildTree(preorder, lr, root.val);
            root.right = buildTree(preorder, root.val, rr);
            return root;
        }
    }
    
    static int idx;
    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return buildTree(preorder,-(int)1e9, (int)1e9);
    }
}