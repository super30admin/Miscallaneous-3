// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;
        ListNode curr = begin;

        int count = 0;

        while (curr.next != null) {
            curr = curr.next;
            count++;

            if (count % k == 0) {
                begin = reverse(begin, curr.next);
                curr = begin;
            }
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode first = start.next;
        ListNode prev = start;
        ListNode curr = start.next;
        ListNode fast = curr.next;

        while (fast != end) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }

        curr.next = prev;
        first.next = end;
        start.next = curr;

        return first;

    }
}