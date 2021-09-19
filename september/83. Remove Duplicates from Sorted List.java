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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)return head;
        ListNode cur = head;
        while(cur != null) {
            ListNode temp = cur.next;
            while(temp != null && temp.val == cur.val) {
                temp = temp.next;
            }
            cur.next = temp;
            cur = temp;
        }
        return head;
    }
}
