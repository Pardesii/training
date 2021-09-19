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
// 3 5


class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(head==null || head.next==null)return head;
        if(left == right)return head;
        
        ListNode prev = null;
        ListNode cur = head;
        
        for(int i=1;i<=left-1;i++) {
            prev = cur;
            cur = cur.next;
        }
        
        ListNode pref = prev;
        ListNode tail = cur;
        
        for(int i=1;i<=right-left+1;i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        tail.next = cur;
        if(pref!=null)pref.next = prev;
        
        return pref==null?prev:head;
        
    }
}
