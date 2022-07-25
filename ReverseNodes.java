//Definition for singly-linked list.
class ListNode {
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

public class ReverseNodes {
    // TC : O(n) n - number of nodes in the given linked list
    // SC : O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 0) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;

        int i=0;

        while(head != null) {
            i++;
            if(i % k == 0) {
                // update begin
                begin = reverse(begin, head.next);
                head = begin;
            }
            head = head.next;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode prev = begin;
        ListNode first = begin.next;
        ListNode curr = begin.next;
        ListNode fast = curr.next;

        while(fast != end) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }

        curr.next = prev;
        begin.next = curr;
        first.next = end;

        return first;
    }
}
