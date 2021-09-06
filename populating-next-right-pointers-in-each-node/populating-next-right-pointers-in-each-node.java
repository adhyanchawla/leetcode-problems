/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        
        while(q.size() != 0) {
            int sz = q.size();
            while(sz-->0) {
                Node rm = q.remove();
                Node nxt = q.peek();
                
                if(rm.left != null && rm.right != null) {
                    rm.left.next = rm.right;
                    if(rm.next != null) {
                        rm.right.next = rm.next.left;
                    }
                    
                }
                
                if(rm.left != null) {
                    q.add(rm.left);
                }
                
                if(rm.right != null) {
                    q.add(rm.right);
                }
            }
        }
        return root;
    }
}