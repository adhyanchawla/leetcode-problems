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
    
    private static ListNode th = null;
    private static ListNode tt = null;
    
    public void addFirstNode(ListNode node) {
        if(th == null) {
            th = tt = node;
        } else {
            node.next = th;
            th = node;
        }
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) return head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        prev.next = head;
        ListNode curr = head;
        
        int i = 1;
        while(i <= right) {
            
            while(i >= left && i <= right) {
                ListNode forw = curr.next;
                curr.next = null;
                addFirstNode(curr);
                curr = forw;
                i++;
            }
            
            if(i > right) {
                prev.next = th;
                tt.next = curr;
                break;
            }
            
            
            i++;
            
            prev = curr;
            curr = curr.next;
        }
        
        tt = th = null;
        return dummy.next;
    }
}