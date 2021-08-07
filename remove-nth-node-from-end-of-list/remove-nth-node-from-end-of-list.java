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
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
        {
            return null;
        }
        
        if(head.next == null)
        {
            return null;
        }
        
        
        ListNode temp1 = head;    
        ListNode temp2 = head;
        ListNode t = null;
        for(int i = 1; i < n; i++)
        {
            temp2 = temp2.next;
        }
        
        if(temp2.next == null)
        {
            head = temp1.next;
            return head;
        }
        
        while(temp2.next != null)
        {
            t = temp1;
            temp2 = temp2.next;
            temp1 = temp1.next;
        }
        if(t != null)
        t.next = temp1.next;

        
        return head;
    }
}