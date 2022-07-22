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

    //Time Complexity: 0(n) where n is the no. of nodes
    //Space Complexity: 0(1)

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }

        ListNode dummy = new ListNode(-1);  //a dummy node
        dummy.next = head;  //placing the dummy node in the list
        ListNode begin = dummy; //node to navigate the list
        int i = 0;  //pointer to traverse the list

        while(head != null){
            i++;    //increasing the pointer
            if(i % k == 0){ //if the pointer is at a place of k, then I will reverse the node from begin to that place
                begin = reverse(begin, head.next);  //function that reverses the nodes
                head = begin;   //also changing the position of head to the next node as head will change while reversing. Suppost it's 1->2->3, so after reversing, it will be 3->2->1 so head will be at node 3 and the next node will be 2, but the next node in the traversal is 4
            }
            head = head.next;   //moving head
        }

        return dummy.next;  //returning dummy as it holds the head of the list
    }
    public ListNode reverse(ListNode begin, ListNode end){  //getting start and end positions to reverse the list
        ListNode prev = begin;  //holds the address of the 1st node and acts as a temporaray node for swapping
        ListNode first = begin.next;    //to return, I need to store the address of the 1st node as it will change during reversal
        ListNode curr = begin.next; //to traverse the list, hence it will hold begin's next value
        ListNode fast = curr.next;  //to figure out when it is the end of the list

        while(fast != end){ //till my pointer reaches the end
            curr.next = prev;   //reversing the node
            prev = curr;
            curr = fast;
            fast = fast.next;   //moving fast to next node
        }
        curr.next = prev;   //the last node is still not reversed, so I will just reverse last node as well
        begin.next = curr;  //setting begin to next node after reversing the list
        first.next = end;   //setting first to end of the list which infact is the 2nd node in the list after reversal
        return first;   // it holds the address of the node that I reverse, so returning that
    }

}