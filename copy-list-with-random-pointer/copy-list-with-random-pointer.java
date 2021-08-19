/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

//without space
class Solution {
    
    public void copyList(Node head) {
        
        Node curr = head;
        
        while(curr != null) {
            Node forw = curr.next;
            
            Node node = new Node(curr.val);
            curr.next = node;
            node.next = forw;
            
            curr = forw;
        }
        
    }
    
    public void copyRandomPointers(Node head) {
        
        Node curr = head;
        
        while(curr != null) {
            Node Random = curr.random;
            if(Random != null) {
                curr.next.random = Random.next;
            }
            
            curr = curr.next.next;
        }
    }
    
    public Node copyRandomList(Node head) {
        copyList(head);
        copyRandomPointers(head);
        
        Node dummy = new Node(-1);
        Node prev = dummy;
        
        Node curr = head;
        
        while(curr != null) {
            
            prev.next = curr.next;
            prev = prev.next;
            
            curr.next = curr.next.next;
            curr = curr.next;
        }
        
        return dummy.next;
    }
}