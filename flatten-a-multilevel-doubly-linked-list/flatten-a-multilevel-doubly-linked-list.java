/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    
    private Node flatten_rec(Node head) {
        Node curr = head, tail = head;
        
        while(curr != null) {
            Node child = curr.child;
            Node forw = curr.next; 
            if(child != null) {
                Node _tail = flatten_rec(child);
                _tail.next = forw;
                if(forw != null) forw.prev = _tail;
                
                curr.next = child;
                child.prev = curr;
                curr.child = null;
                curr = tail;
                
            } else {
                curr = forw;
            }
            
            if(curr != null) tail = curr;
        }
        
        return tail;
    }
    
    public Node flatten(Node head) {
        if(head != null) flatten_rec(head);
        return head;
    }
}