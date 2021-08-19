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

class Solution {
    public Node copyRandomList(Node head) {
        
        HashMap<Node, Node> map = new HashMap<>();
        
        Node nHead = new Node(-1);
        Node prev = nHead;
        Node curr = head;
        
        while(curr != null) {
            Node node = new Node(curr.val);
            prev.next = node;
            
            map.put(curr, node);
            
            curr = curr.next;
            prev = prev.next;
        }
        
        curr = head;
        nHead = nHead.next;
        prev = nHead;
        
        while(curr != null) {
            if(map.get(curr.random) == null) {
                prev.random = null;
            } else if(map.get(curr.random) != null) {
                prev.random = map.get(curr.random);
            }
            
            curr = curr.next;
            prev = prev.next;
        }
        
        return nHead;
    }
}