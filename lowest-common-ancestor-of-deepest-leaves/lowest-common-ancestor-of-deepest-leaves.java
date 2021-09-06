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
    
    static int depth;
    public int helper(TreeNode root, ArrayList<TreeNode> ans, int ht, int depth) {
        if(root == null) {
            return 0;
        }
        
        if(depth == ht) {
            ans.add(root);
        } else
        { 
            depth++;   
        }
        
        int lht = helper(root.left, ans, ht, depth);
        int rht = helper(root.right, ans, ht, depth);
        
        return depth = Math.max(lht, rht) + 1;
    }
    
    public ArrayList<TreeNode> getLca(TreeNode root, int d) {
        if(root == null) return new ArrayList<>();
        
        if(root.val == d) {
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(root);
            return base;
        }
        
        ArrayList<TreeNode> lans = getLca(root.left, d);
        if(lans.size() > 0) {
            lans.add(root);
            return lans;
        }
        
        ArrayList<TreeNode> rans = getLca(root.right, d);
        if(rans.size() > 0) {
            rans.add(root);
            return rans;
        }
        
        return new ArrayList<>();
    }
    
    public int depth(TreeNode root) {
        return root != null ? Math.max(depth(root.left), depth(root.right)) + 1 : -1;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        int ht = depth(root);
        depth = 0;
        helper(root, ans, ht, depth);
        
        // for(TreeNode ele : ans) {
        //     //System.out.print(ele.val + " ");
        // }
        
        if(ans.size() == 1){
            return ans.get(0);
        } 
        else {
            int d1 = ans.get(0).val;
            int d2 = ans.get(ans.size() - 1).val;
            
            ArrayList<TreeNode> l1 = getLca(root, d1);
            ArrayList<TreeNode> l2 = getLca(root, d2);
            
            // for(TreeNode t : l2) {
            //     System.out.print(t.val + " ");
            // }
            
            int i = l1.size() - 1;
            int j = l2.size() - 1;
            while(i >= 0 && j >= 0 && l1.get(i).val == l2.get(j).val) {
                i--;
                j--;
            }
            
            return l1.get(i+1);
        }
    }
}