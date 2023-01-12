// Time Complexity : O(n) where n = number of elements in linked list
// Space Complexity : O(1)

// Definition for singly-linked list.
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

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode begin = dummy;

        while (head != null) { // O(n)
            count++;

            if (count % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode first = begin.next;
        ListNode prev = begin;
        ListNode curr = begin.next;
        ListNode fast = curr.next;

        while (fast != end) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }

        curr.next = prev;
        begin.next = curr;
        first.next = fast;

        return first;
    }
}