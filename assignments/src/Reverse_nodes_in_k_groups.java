// Approach: Handle all the cases. Attach the reversed lists of k size. Join the remaining list
// as it is.
// Time: O(n)
// Space: O(1)

class Reverse_nodes_in_k_groups {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode curr = head;
        ListNode prev = dummyHead;

        while (curr != null) {
            ListNode start = curr;
            ListNode end = curr;

            // shift end ptr to k-1 places for reversal
            for (int i = 1; i<=k-1 && end != null; i++) {
                end = end.next;
            }

            if (end == null) {
                break;
            }

            // Logic to connect two reversed lists ->
            ListNode endNext = end.next;
            reverse(start, end);
            prev.next = end;
            start.next = endNext;

            prev = start;
            curr = endNext;
        }

        return dummyHead.next;
    }

    private void reverse(ListNode start, ListNode end) {
        ListNode endNext = end.next;
        ListNode prev = null, curr = start;

        while (curr != endNext) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}