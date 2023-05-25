/*
Reverse Nodes in K-Groups
approach: we can do it using stacks, but with below we have to just keep track of nodes using pointers
time: O(n)
space: O(1)
 */
public class Problem2 {
    class ListNode {
        int val;
        ListNode next;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head, begin = dummy;

        while (curr!=null) {
            count++;
            if (count%k==0) {
                begin = reverse(begin, curr.next);
                curr = begin.next;
            }
            else
                curr = curr.next;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode prev = begin, curr = begin.next, first = begin.next, fast = curr.next;

        while (fast!=end) {
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
