
//O(N) will be the TC
//O(1) is the SC
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)    return head;
        
        ListNode temp = new ListNode(-1);
        temp.next = head;
            
        int c = 0;
        ListNode begin = temp;
        
        while(head != null){
            c++;
            if(c % k == 0){
                begin = reverse(begin, head.next);
                head = begin.next;
            } else{
                head = head.next;
            }
        }
            
        return temp.next;
    }
    
    public ListNode reverse(ListNode begin, ListNode end){
        ListNode prev = begin;
        ListNode curr = begin.next;
        ListNode fast = curr.next;
        
        ListNode start = begin.next; // curr 
            
        while(fast != end){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        
        begin.next = curr;
        start.next = end;
        
        return start;
    }
}
