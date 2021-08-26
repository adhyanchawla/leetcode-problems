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
    //divide and conquer
    
    public ListNode mergeTwoSortedLL(ListNode left, ListNode right) {
        if(left == null || right == null) return left != null ? left : right;
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        ListNode c1 = left;
        ListNode c2 = right;
        
        while(c1 != null && c2 != null) {
            if(c1.val < c2.val) {
                prev.next = c1;
                c1 = c1.next;
                prev = prev.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
                prev = prev.next;
            }
        }
        
        if(c1 != null) prev.next = c1;
        if(c2 != null) prev.next = c2;
        
        return dummy.next;
    }
    
    public ListNode mergeKSorted(ListNode[] lists, int si, int ei) {
        if(si > ei) return null;
        if(si == ei) return lists[si];
        
        int mid = (si + ei) / 2;
        
        ListNode left = mergeKSorted(lists, si, mid);
        ListNode right = mergeKSorted(lists, mid + 1, ei);
        
        return mergeTwoSortedLL(left, right);
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return mergeKSorted(lists, 0, lists.length - 1);
    }
}