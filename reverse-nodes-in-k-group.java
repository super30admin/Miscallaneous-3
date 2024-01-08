// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

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
        if(head == null || head.next == null || k == 1)
            return head;
        ListNode begin;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        begin = dummy;
        int i = 0;
        while(head != null){
            i++;
            if(i % k == 0){
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode begin, ListNode end){
        ListNode prev = begin;
        ListNode curr = begin.next;
        ListNode fast = begin.next.next;
        ListNode first = curr;
        while(fast != end){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        first.next = end;
        begin.next = curr;
        return first;
    }
}