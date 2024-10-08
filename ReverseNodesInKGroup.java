//TC : O(N)
//SC : O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int count = 0;
        ListNode curr = dummy;
        ListNode begin = dummy;

        while (curr.next != null) {
            curr = curr.next;
            count++;
            if (count % k == 0) {
                begin = reverseNodes(begin, curr.next);
                curr = begin;
            }
        }
        return dummy.next;
    }

    private ListNode reverseNodes(ListNode start, ListNode end) {
        ListNode prev = start;
        ListNode curr = start.next;
        ListNode fast = curr.next;
        ListNode first = start.next;
        while (fast != end) {
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