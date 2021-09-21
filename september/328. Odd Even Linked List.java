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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode oddit = odd;
        ListNode even = new ListNode(0);
        ListNode evenit = even;
        boolean flag = true;
        while(head != null) {
            if(flag == true) {
                oddit.next = head;
                oddit = oddit.next;
            }
            else {
                evenit.next = head;
                evenit = evenit.next;
            }
            flag = !flag;
            head = head.next;
        }
        evenit.next = null;
        oddit.next = even.next;
        return odd.next;
        
    }
}