// Time complexity - O(n)
// Space complexity - O(1)
// Works on leetcode

class Solution {
    private ListNode reverse(ListNode begin, ListNode end){
        ListNode prev = begin;
        ListNode current = begin.next;
        ListNode next = current.next;
        ListNode head = begin.next;
        
        while(next != end){
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        current.next = prev;
        begin.next = current;
        head.next = end;
        return head;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
      if(head == null){
          return head;
      } 
      ListNode dummy = new ListNode(-1);
      dummy.next = head;
      ListNode begin = dummy;
      ListNode first = null;
      ListNode current = head;
      int i = 0; 
      while(current != null){
          i = i + 1;
          if(i % k == 0){
              first = reverse(begin, current.next);
              begin = first;
              current = first.next;
          }
          else{
              current = current.next;
          }
      }    
      return dummy.next;
    }
}
