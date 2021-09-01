/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "n";
        }
        
        String ls = serialize(root.left);
        String rs = serialize(root.right);
        
        return root.val + " " + ls + " " + rs;
    }
    
    public TreeNode helper(String[] tokens) {
        if(tokens[idx].equals("n")) {
            idx++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(tokens[idx++]));
        root.left = helper(tokens);
        root.right = helper(tokens);
        
        return root;
    }

    // Decodes your encoded data to tree.
    static int idx;
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(" ");
        idx = 0;
        return helper(tokens);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));