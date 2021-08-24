/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return quickSort_(head)[0];
    }
    
    public ListNode[] segregate(ListNode head, int pivotIdx) {
        
        ListNode pNode = head;
        
        while(pivotIdx-->0) pNode = pNode.next;
        
        ListNode small = new ListNode(-1);
        ListNode big = new ListNode(-1);
        
        ListNode s = small;
        ListNode b = big;
        
        ListNode curr = head;
        while(curr != null) {
            if(curr != pNode) {
                if(curr.val < pNode.val) {
                    s.next = curr;
                    s = s.next;
                } else {
                    b.next = curr;
                    b = b.next;
                }
            }
            curr = curr.next;
        }
        
        s.next = null;
        pNode.next = null;
        b.next = null;
        
        return new ListNode[]{small.next, pNode, big.next};
    }
    
    public ListNode[] mergeLists(ListNode[] left, ListNode pNode, ListNode[] right) {
        ListNode head = null, tail = null;
        if(left[0] != null && right[0] != null) {
            left[1].next = pNode;
            pNode.next = right[0];
            head = left[0];
            tail = right[1];
        } else if(left[0] != null) {
            left[1].next = pNode;
            head = left[0];
            tail = pNode;
        } else if(right[0] != null) {
            pNode.next = right[0];
            head = pNode;
            tail = right[1];
        } else{
            head = tail = pNode;
        }
        
        return new ListNode[] {head, tail};
    }
    
    public int length(ListNode head) {
        int len = 0;
        ListNode curr = head;
        
        while(curr != null) {
            curr = curr.next;
            len++;
        }
        
        return len;
    }
    
    public ListNode[] quickSort_(ListNode head) {
        if(head == null || head.next == null)
            return new ListNode[]{head, head};
            
        int mid = length(head) / 2;
        
        ListNode[] ans = segregate(head, mid);
        
        ListNode[] left = quickSort_(ans[0]);
        ListNode[] right = quickSort_(ans[2]);
        
        return mergeLists(left, ans[1], right);
    }

    
}