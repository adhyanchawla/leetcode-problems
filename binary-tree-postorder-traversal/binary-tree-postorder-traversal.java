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
    public void postorderTraversal(TreeNode root, List<Integer> ans)
    {
        if(root == null)
            return;
        
        postorderTraversal(root.left, ans);
        postorderTraversal(root.right, ans);
        ans.add(root.val);
    }
    
    public static TreeNode rightMostNode(TreeNode node, TreeNode curr) {
      while(node.left != null && node.left != curr) {
          node = node.left;
      }
      
      return node;
  }
    
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
    
        TreeNode curr = root;
        while(curr != null) {
            TreeNode ln = curr.right;
            if(ln == null) {
                //root pe ho aap
                ans.add(curr.val);
                curr = curr.left;
            } else {
                TreeNode rmn = rightMostNode(ln, curr);
                if(rmn.left == null) {
                    //create a thread before going to left subtree
                    //left pr jaane se pehle add krna hai
                    rmn.left = curr;
                    ans.add(curr.val);
                    curr = curr.right;
                } else{
                    //left subtree is done, moving from left to right
                    rmn.left = null;
                    curr = curr.left;
                }
            }
        }
        Collections.reverse(ans);
    return ans;
    }
}