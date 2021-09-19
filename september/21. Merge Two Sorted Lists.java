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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = l1; ListNode sec = l2;
        ListNode ret = new ListNode(0);
        ListNode ref = ret;
        while(first!=null && sec!=null)
        {
            if(first.val<=sec.val)
            {
                ret.next = new ListNode(first.val);
                first = first.next;
            }
            else
            {
                ret.next = new ListNode(sec.val);
                sec = sec.next;
            }
            ret = ret.next;
        }
        while(first!=null)
        {
            ret.next = new ListNode(first.val);
            first = first.next;
            ret = ret.next;
        }
        while(sec != null)
        {
            ret.next = new ListNode(sec.val);
            sec = sec.next;
            ret = ret.next;
        }
        return ref.next;
    }
}
