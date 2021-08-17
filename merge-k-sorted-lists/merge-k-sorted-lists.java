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
    public ListNode mergeTwoSortedLL(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 != null ? l1 : l2;
        
        ListNode dummy = new ListNode(-1);
        ListNode c = dummy;
        
        ListNode t1 = l1;
        ListNode t2 = l2;
        
        while(t1 != null && t2 != null) {
            if(t1.val < t2.val) {
                c.next = t1;
                c = c.next;
                t1 = t1.next;
            } else {
                c.next = t2;
                c = c.next;
                t2 = t2.next;
            }
        }
        
        if(t1 != null) {
            c.next = t1;
        }
        
        if(t2 != null) {
            c.next = t2;
        }
        
        return dummy.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists, int si, int ei) {
        if(si == ei) {
            return lists[si];
        }
        
        int mid = (si + ei) / 2;
        ListNode leftList = mergeKLists(lists, si, mid);
        ListNode rightList = mergeKLists(lists, mid + 1, ei);
        
        return mergeTwoSortedLL(leftList, rightList);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }
}