// Time complexity = O(n)
// Space complexity = O(1)
// Take the example of [1,2,3,4,5,6,7,8]
// especially take the example of [4,5,6], we need to reverse this.
// how do we go about it ?
// we need 5 nodes -> one before and one after the list we need to reverse.
// so, [3,4,5,6,7] is what we need .
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode begin = dummy;
        dummy.next = head;
        ListNode curr = dummy;
        int count =0;
        while(curr.next!=null) {
            curr = curr.next;
            count++;
            if(count%k ==0) {
                begin = reverse(begin, curr.next);
                curr = begin;
            }
        }
        return dummy.next;        
    }
    // k + 2 nodes for reversal including the prev node and the node till which we need to stop at.
    // whiteboard this.
    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode prev = begin;
        ListNode curr = begin.next;
        ListNode first = curr;
        ListNode fast = curr.next;
        while(fast!=end) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;            
        }
        curr.next = prev;
        first.next = end; // 4-> 7
        begin.next = curr;
        return first; // 4 is returned .
        
    }
}