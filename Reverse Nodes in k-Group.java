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
        
        if(head == null || k == 0) return head;

        ListNode dummy = new ListNode(-1);
        ListNode begin = dummy;
        dummy.next = head;
        int count = 0;

        while(head != null)
        {
            count++;
            
            if(count % k == 0)
            {
                // Here head.next is end
                begin = reverse(begin, head.next);

                // Now my head becomes begin.next
                head = begin.next;
            }

            else head = head.next;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode begin, ListNode end)
    {
        ListNode prev = begin, curr = begin.next, next = curr.next;

        // Generally for reversing a linked list we write curr != null but here our next should go till end
        while(next != end)
        {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }

        // This is bcoz when my next has reached end I had to still connect my curr, next to prev
        curr.next = prev;

        // Before reversing we have begin node -> 1 -> 2 -> 3 -> end node. Now after reversal we have
        // begin node   3-> 2-> 1    end node
        // We have to now connect begin node next to curr and node 1 next to end node

        // begin.next as of now is still node 1
        ListNode first = begin.next;

        // Now update begin. next to curr. This is because curr node is 3
        begin.next = curr;

        // Now make 1 next point to end node
        first.next = end;

        // After all this process we need to return the begin node for the next k set linked list
        // As of now the list looks like dummy node -> 3 -> 2 -> 1 -> 4 -> 5. Previously when we wanted to reverse 
        // 1 -> 2 -> 3 begin node was dummy node and end node was 4. Similarly when we now start at node 4 begin node
        // for it should be node 1. so return that

        return first;
    }
}