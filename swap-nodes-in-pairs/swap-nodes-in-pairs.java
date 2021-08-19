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
    
    private static ListNode tt = null;
    private static ListNode th = null;
    
    public void addFirstNode(ListNode node) {
        if(th == null) {
            th = tt = node;        
        } else {
            node.next = th;
            th = node;
        }
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
    
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode curr = head;
        ListNode oh = null, ot = null;
        int k = 2;
        
        int len = length(head);
        
        while(len >= k) {
            int tlen = k;
            while(tlen-->0) {
                ListNode forw = curr.next;
                curr.next = null;
                addFirstNode(curr);
                curr = forw;
            }
            
            if(oh == null) {
                oh = th;
                ot = tt;
            } else {
                ot.next = th;
                ot = tt;
            }
            tt = th = null;
            len -= k;
        }
        
        if(curr != null)
            ot.next = curr;
        tt = th = null;
        return oh;
        
    }
}