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
        ListNode begin = dummy;
        dummy.next= head;
        
        int i=0;
        while(head!=null){
            i++;
            if(i%k==0){
                begin = reverse(begin, head.next);
                head = begin.next;
            }
            else{    
                head = head.next;
            }
        }
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode begin, ListNode end){
        
        ListNode prev= begin;
        ListNode curr= prev.next;
        ListNode fast= curr.next;
        ListNode first =curr;
        
        while(fast!= end){
            curr.next= prev;
            prev= curr;
            curr=fast;
            fast= curr.next;
        }
        
        curr.next = prev;
        begin.next = curr;
        first.next= end;
        
        return first;
    }
}
