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
    
    public ListNode midNode(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public ListNode mergeTwoSortedLL(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 != null ? l1 : l2;
        
        ListNode c1 = l1;
        ListNode c2 = l2;
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        while(c1 != null && c2 != null) {
            if(c1.val < c2.val) {
                prev.next = c1;
                prev = prev.next;
                c1 = c1.next;
            } else {
                prev.next = c2;
                prev = prev.next;
                c2 = c2.next;
            }
        }
        
        if(c1 != null) prev.next = c1;
        if(c2 != null) prev.next = c2;
        
        return dummy.next;
    }
    
    public ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode mid = midNode(head);
        ListNode nHead = mid.next;
        mid.next = null;
        
        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(nHead);
        
        return mergeTwoSortedLL(l1, l2);
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        return mergeSort(head);
    }
}