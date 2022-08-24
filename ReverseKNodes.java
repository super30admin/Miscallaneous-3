//time complexity: O(nk)
//space complexity: O(1)

class ListNode {
    int val;
     ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        ListNode dummy=new ListNode();
        dummy.next=head;
        int i=1;
        ListNode prev=dummy;
        ListNode curr=head;
        while(curr!=null)
        {
            if(i%k==0)
            {
                ListNode node=reverse(head,curr);
                prev.next=curr;
                head.next=node;
                i=1;
                prev=head;
                head=head.next;
                curr=head;
            }
            if(curr==null) return dummy.next;
            curr=curr.next;
            i++;
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode head, ListNode tail)
    {
       ListNode prev=head;
        ListNode curr=head.next;
        while(prev!=tail)
        {
            ListNode next1=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next1;
            
        }
        return curr;
    }
}