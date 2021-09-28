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
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1!=null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        
        while(l2!=null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode head = null;
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()) {
            int first = (s1.size() == 0)?0:s1.pop();
            int sec = (s2.size() == 0)?0:s2.pop();
            
            int sum = first+sec+carry;
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            
            newNode.next = head;
            head = newNode;
            
        }
        if(carry == 1) {
            ListNode newNode = new ListNode(1);
            // carry = sum/10;
            
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
}