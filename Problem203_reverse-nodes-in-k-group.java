// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int i = 0;
        ListNode begin = dummy;
        while(head != null) {
            i++;
            if(i % k == 0) {
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
        while(fast != end) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        //System.out.println(prev.val);
        begin.next = curr;
        //System.out.println(curr.val);
        first.next = end;
        return first;
    }
}