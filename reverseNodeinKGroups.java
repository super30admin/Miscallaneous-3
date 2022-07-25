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
//TC : O(N)
//SC : O(1)
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k==1) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode slow = dummy.next;
        ListNode fast = dummy.next;
        int ctr = 0;
        while(fast!=null){
            fast = fast.next;
            ctr++;
            if(ctr==k){
                ListNode rev = reverse(slow,k);
                prev.next = rev;
                slow.next = fast;
                prev = slow;
                slow = fast;
                ctr = 0;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head,int k){

        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        int ctr = 1;
        while(ctr!=k){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
            ctr++;
        }
        curr.next = prev;
        return curr;
    }
}