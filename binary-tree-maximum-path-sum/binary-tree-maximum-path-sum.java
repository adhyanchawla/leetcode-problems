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
    
    public int maxPathSum(TreeNode root) {
    pair pair = maxPathSumHelper(root);
    return pair.maxPath;
}
    
    private pair maxPathSumHelper(TreeNode root){
        if(root == null){
            return new pair(Integer.MIN_VALUE, 0);
        }
    
        int val = root.val;
        pair pairLeft = maxPathSumHelper(root.left);
        pair pairRight = maxPathSumHelper(root.right);
    
        int maxPath = Math.max(pairLeft.maxLength + pairRight.maxLength + val,  Math.max(pairLeft.maxPath, pairRight.maxPath));
        int maxLength = Math.max(0, Math.max(pairLeft.maxLength, pairRight.maxLength) + val);
    
        return new pair(maxPath, maxLength);
    }


    class pair{

    int maxPath;
    int maxLength;

    public pair(int maxPath, int maxLength){
        this.maxPath = maxPath;
        this.maxLength = maxLength;
    }
    }
}