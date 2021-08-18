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
        ListNode temp = head;
        
        int len = 0;
        
        while(temp != null) {
            temp = temp.next;
            len++;
        }
        
        return len;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) {
            return head;
        }
        
        int len = length(head);
        
        ListNode oh = null;
        ListNode ot = null;
        
        ListNode curr = head;
        
        while(len >= k) {
            int tlen = k;
            
            while(tlen-->0){
                ListNode forw = curr.next;
                curr.next = null;
                addFirstNode(curr);
                curr = forw;
            }
            
            len -= k;
            
            if(oh == null) {
                oh = th;
                ot = tt;
            } 
            else {
                ot.next = th;
                ot = tt;
            }
            
            
            th = null;
            tt = null;
        }
        
        ot.next = curr;
        
        return oh;
    }
}