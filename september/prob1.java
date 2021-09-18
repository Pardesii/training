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
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode cur1 = l1; ListNode cur2 = l2;
        
        int carry = 0;
        
        while(cur1 != null || cur2 != null)
        {
            int first = (cur1 == null)?0:cur1.val;
            int sec = (cur2 == null)?0:cur2.val;
            
            int sum = (first+sec+carry);
            carry = (sum>=10)?1:0;
            
            cur.next = new ListNode(sum%10);
            
            cur = cur.next;
            if(cur1 != null)cur1 = cur1.next;
            if(cur2 != null)cur2 = cur2.next;
            
        }
        if(carry == 1)cur.next = new ListNode(1);
        
        return head.next;
    }
}
