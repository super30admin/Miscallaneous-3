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
 /*
 The question's statement is tricky. The goal is not to reverse the linked list completely, but rather in groups or k steps at a time. 
 Lets say our list has 10 elements, and k=2, so we would want to reverse the first two elements, and then the next two elements and so on
 reversing in group WOULD NOT MAKE the list reverse as if it was reversed altogeather, one important thing to note.
 We are rather reversing the list in parts. 

 Intution:

 The goals is to take a linked list and reverse in part. But there is one catch

 1: We will take on pointer on one element before the actual element and call it as begin, we then count to k and m0ve the c pointer by the k times, where the c is arrived now, will be the last element, so we will take another pointer as end on this.

2: We need to reverse the list after the begin and before the end pointer

3: We will take a prev pointer on begin, current on the begin's next and fast on the current next' and iterate until fast reached end

4: at each iteration we will make the current's' next point to prev, and advance all pointers

5: when the iteration finishes, there is one last element left out , as current is not pointing to prev , so we wil make that connection

we will return the position of the very first element before the reversal as it now bacame the very last element and take this as a new begin and start all over


Time : O(n)
Space : O (1)
 */
class Solution {
    ListNode dummy;
    public ListNode reverseKGroup(ListNode head, int k) {

        dummy = new ListNode(-1); // dummy node to hold a prev pointer to the head
        dummy.next = head;
        ListNode begin = dummy; // since begin needs to be one point before so will point to the dummy
        ListNode c = dummy; // the c (curent) pointer to dummy, it will advance k steps, which would point this to the last element to be reversed in the group
        boolean isFirst = true;
        while(c !=null){ 
        int count = k;
        while(c!=null && (count >0)){ // point c to the begin pointer and advance it k steps
            c = c.next;
            count--;
        }
        if(c==null) break; // if we could not reach the k steps, (there maybe left out nodes), in that case just return 
        begin = reverse(begin, c.next); // reverse and begin to point to the last element in the reverse
        if(isFirst){ // for the very first transacion, the last element in the first group would be the new head of the reversed list, which will be pointed by the c pointer
            head = c;
            isFirst = false; // only need to do it once
        }
        c = begin; // start the c from begin
        }

        return head;
    }


    private ListNode reverse(ListNode begin, ListNode end){
        ListNode prev = begin; // pointer to prev
        ListNode current = begin.next; // pointer to first elemet
        ListNode first = current; // save ref to the first element as after reversal it will become the last and needs to be connected with the end
        ListNode fast = current.next; 
        while(fast!=null && fast!=end){
            current.next = prev; // point current next to prev to reverse
            prev = current; // move prev to current position
            current = fast; // move current to next position
            fast = fast.next; // move fast to next position
        }
        // at this point , the current and prev are not connected, since fast reached end before the last connection can be made
        current.next = prev;  // making the last reverse connection
        begin.next = current; // make the begin pointer connect to the first item in the reverse list to make the connection
        first.next = end; // make the earlier first element (before the list) which now bcame the last element connect to the end
        return first; // return the first (last element in the reversed list) to the caller so that begin and count can start from here
    }
}