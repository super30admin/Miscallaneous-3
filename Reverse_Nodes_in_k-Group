class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;
        int i = 0;
        
        while(head != null){
            i++;
            if(i % k == 0){
                begin = reverse(begin, head.next);
                head = begin.next;
            }else{
                head = head.next;
            }
                
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode begin, ListNode end){
        ListNode prev = begin;
        ListNode curr = prev.next;
        ListNode fast = curr.next;
        ListNode first = curr;
        
        while(fast != end){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        
        curr.next = prev;
        first.next = end;
        begin.next = curr;
        return first;
    }
}

//TC: O(n)
//SC: O(1)
