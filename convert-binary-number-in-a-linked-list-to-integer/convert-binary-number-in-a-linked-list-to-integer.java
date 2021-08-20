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
    
    public int length(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            len++;
        }
        
        return len;
    }
    
    public int getDecimalValue(ListNode head) {
        
        if(head == null) return 0;
        
        if(head.next == null) return head.val;
        
        int len = length(head);
        ListNode curr = head;
        
        int sum = 0;
        while(curr != null) {
            
            int val = curr.val;
            sum += ((int)(Math.pow(2, len-1)) * val);
            len--;
            
            curr= curr.next;
        }
        
        return sum;
    }
}