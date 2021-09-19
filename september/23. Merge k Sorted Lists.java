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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b)->{
            return Integer.compare(a.val,b.val);
        });
        
        for(ListNode cur : lists) {
            if(cur != null) {
                pq.add(cur);
            }
        }
        
        ListNode head = new ListNode(0);
        ListNode cur = head;
        
        while(!pq.isEmpty()) {
            ListNode nodeToBeAdded = pq.poll();
            cur.next = nodeToBeAdded;
            
            if(nodeToBeAdded.next != null) {
                pq.add(nodeToBeAdded.next);
            }
            
            cur = cur.next;
            
        }
        
        return head.next;
        
    }
}
