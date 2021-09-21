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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // l1 = reverse(l1);
        // l2 = reverse(l2);
        
        ListNode ans = new ListNode(-1);
        
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        
        ListNode a = ans;
        int c = 0;
        
        while(temp1 != null || temp2 != null || c != 0)
        {
            int val1 = (temp1 != null) ? temp1.val : 0;
            int val2 = (temp2 != null) ? temp2.val : 0;
            
            int sum = val1 + val2 + c;
            int finalSum = sum % 10;
            c =  sum / 10;
            
            a.next = new ListNode(finalSum);
            a = a.next;
            
            if(temp1 != null)
                temp1 = temp1.next;
            if(temp2 != null)
                temp2 = temp2.next;
        }
        return ans.next;
    }
    
    public ListNode reverse(ListNode h1)
    {
        ListNode curr = h1;
        ListNode prev = null;
        
        while(curr != null)
        {
            ListNode currkanext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currkanext;
        }
        
        return prev;
    }
}