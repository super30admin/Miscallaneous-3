// Time Complexity : O(N)
// Space Complexity : O(1),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class ReverseNodesInKGroup {
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
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode begin = dummy;
            int i = 0;
            while(head != null) {
                i++;
                if(i%k == 0) {
                    begin = reverse(begin, head.next);
                    head = begin.next;
                } else {
                    head = head.next;
                }
            }
            return dummy.next;
        }

        private ListNode reverse (ListNode begin, ListNode end) {
            ListNode prev = begin;
            ListNode curr = prev.next;
            ListNode nxt = curr.next;

            while(nxt != end) {
                curr.next = prev;
                prev = curr;
                curr = nxt;
                nxt = nxt.next;
            }

            curr.next = prev;
            ListNode connectionToNext = begin.next;
            begin.next.next = end;
            begin.next = curr;

            return connectionToNext;
        }
    }
}
