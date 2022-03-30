// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We reverse k elements in one batch, and move on to the next batch
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k==0) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode begin = dummy;
        ListNode end = head;

        int i=0;

        while (head != null) {
            i++;
            if (i%k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            }
            else {
                head = head.next;
            }
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode prev = begin;
        ListNode first = begin.next;
        ListNode curr = first;
        ListNode fast = curr.next;

        while (fast != end) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;

        // change the pointers of the begin and end
        begin.next = curr;
        first.next = end;

        // return the first since we want to mark it as the new beginning
        return first;
    }
}