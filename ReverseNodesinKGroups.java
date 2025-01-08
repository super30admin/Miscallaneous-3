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
        ListNode dummy= new ListNode(-1);
        dummy.next=head;
        ListNode start=dummy;
        ListNode curr=head;
        int count=0;

        while(curr!=null){
            curr=curr.next;
            count++;

            if(count % k==0){
                start=reverse(start, curr);
            }
        }
        return dummy.next;
    }


    private ListNode reverse(ListNode start,ListNode end){
        ListNode prev=start;
        ListNode curr=start.next;
        ListNode first=start.next;
        while(curr!=end){
            ListNode temp= curr.next;
            curr.next= prev;
            prev=curr;
            curr=temp;
        }

        start.next=prev;
        first.next=end;


        return first;
    }
}