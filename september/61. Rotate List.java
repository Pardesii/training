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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)return null;
        
        ListNode cur = head;
        int sz = 0;
        while(cur != null) {
            cur = cur.next;
            sz++;
        }
        
        k %= sz;
        System.out.println(sz);
        if(k == 0)return head;
        int rem = sz - k - 1;
        
        cur = head;
        
        for(int time=1;time<=rem;time++)cur = cur.next;
        
        ListNode last = cur.next;
        
        cur.next = null;
        
        ListNode temp = last;
        while(temp != null && temp.next!= null) {
            temp = temp.next;
        }
        
        temp.next = head;
        return last;
        
    }
}
