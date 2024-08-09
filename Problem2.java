
// TC: O(N)
// SC: O(1)
public class Problem2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head; 

        ListNode start = dummy;
        ListNode curr = head; 
        int count=1;

        while(curr!=null){
            if(count%k == 0){
                start = reverse(start, curr.next);
                curr = start;
            }
            curr = curr.next;
            count++;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode start, ListNode end){
        ListNode first = start.next;

        ListNode prev = start;
        ListNode curr = start.next;
        while(curr!=end){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        first.next = end;
        start.next = prev;
        return first;
    }
}
