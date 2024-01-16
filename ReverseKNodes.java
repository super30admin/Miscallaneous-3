
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class ReverseKNodes {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode curr = head;
        ListNode start = dummy;
        int count = 0;
        while(curr!=null){
            count++;
            if(count % k ==0){
                start = reverse(start,curr.next);
                curr = start;
            }
            curr=curr.next;
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode start, ListNode end){
        ListNode prev = start;
        ListNode curr = start.next;
        ListNode fast = curr.next;
        ListNode first = curr;
        while(fast!=end){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next=prev;
        start.next = curr;
        first.next = fast;
        return first;
    }
}