// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int i = 0;
        ListNode begin = dummy;
        while (head != null) {
            i++;
            // take sections and reverse
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode prev = begin;
        ListNode fast = curr.next;
        // reverse the nodes
        while (fast != end) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        //
        curr.next = prev;
        ListNode first = begin.next;
        begin.next.next = end;// 1-->4
        begin.next = curr;// dummy-->3
        return first;
    }
}