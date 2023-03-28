public class ReverseNodeInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        int i = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;
        while(head!=null){
            i++;
            if(i%k==0){
                begin = reverseList(begin, head.next);
                head = begin.next;
            }else{
                head = head.next;
            }
        }
        return dummy.next;
    }
    private ListNode reverseList(ListNode begin, ListNode end){
        ListNode prev = begin;
        ListNode curr = prev.next;
        ListNode fast = curr.next;
        ListNode first = curr;
        while(fast!=end){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        begin.next = curr;
        first.next = end;
        return first;
    }
}

// TC - O(nk) ~ O(2n) ~ O(n)
// SC - O(1)
