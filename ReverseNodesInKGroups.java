// LC 25

/**
 * Keep track of the tail of previous group to connect with the new reversed group's head.
 * Also, the next group's head becomes the new tail (due to reversal).
 *
 * TC: O(n)
 * SC: O(1)
 */
public class ReverseNodesInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int n = 0;
        while (curr != null) {
            curr = curr.next;
            n++;
        }

        int steps = n / k;
        curr = head;
        ListNode start;
        ListNode nextStart = new ListNode(); // this cannot work due to local scope of variables
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (steps > 0) {
            start = curr;
            curr = reverse(curr, k, tail); // returns next group's head
            tail = start;
            steps--;
        }
        // required for n%k != 0, i.e., remainder of the list
        tail.next = curr;
        return dummy.next;
    }

    private ListNode reverse(ListNode curr, int k, ListNode tail) {
        ListNode prev = null, next;

        while (k > 0 && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        // previous reversed group's tail is connected to new head
        tail.next = prev;
        // return the next group's head
        return curr;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
