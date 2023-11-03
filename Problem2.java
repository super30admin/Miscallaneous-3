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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode start = dummy;
        ListNode curr = dummy;
        dummy.next = head;
        int count = 0;
        while(curr.next != null){
            count++;
            curr = curr.next;
            if(count % k == 0){
                curr = reverse(start, curr.next);
                start = curr;
            }
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode start, ListNode end){
        ListNode prev = start;
        ListNode curr = start.next;
        ListNode fast = curr.next;
        ListNode first = curr;
        while(fast != end){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        start.next = curr;
        first.next = end;
        return first;
    }
}
