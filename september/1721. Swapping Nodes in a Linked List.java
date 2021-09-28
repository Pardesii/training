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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        
        ListNode first = dummy;
        ListNode sec = dummy;
        ListNode third = dummy;
        
        for(int time=0;time<k-1;time++) {
            first = first.next;
        }
        
        for(int time=0;time<k+1;time++) {
            third = third.next;
        }
        
        while(third != null) {
            third = third.next;
            sec = sec.next;
        }
        
        ListNode cur1 = first.next;
        ListNode cur2 = sec.next;
        
        first.next = cur2;
        sec.next = cur1;
        
        ListNode temp = cur1.next;
        cur1.next = cur2.next;
        cur2.next = temp;
        
        return dummy.next;
    }
}