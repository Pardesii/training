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
    public ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode(0);
        ListNode sec = new ListNode(0);
        ListNode fc = first, sc = sec;
        while(head != null) {
            if(head.val<x) {
                first.next = head;
                first = first.next;
            }
            else {
                sec.next = head;
                sec = sec.next;
            }
            head = head.next;
        }
        sec.next = null;
        first.next = sc.next;
        return fc.next;
    }
}