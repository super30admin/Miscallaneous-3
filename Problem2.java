// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        ListNode curr = head;
        ListNode start = dummy;
        while(curr!=null){
            count++;
            if(count%k == 0){
                start = reverse(start,curr.next);
                curr = start;
            }
            
            curr = curr.next;
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode start, ListNode end){
        ListNode prev = start;
        ListNode curr = start.next;
        ListNode first = curr;
        ListNode fast = curr.next;
        while(fast!=end){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        start.next = curr;
        first.next = fast;
        return first;
    }
}