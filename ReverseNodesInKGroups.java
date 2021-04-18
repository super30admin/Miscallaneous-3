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
//TC:O(N)
//SC:O(1)
//Did it run successfully on Leetcode?:Yes
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        if (k == 0)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        
        while (curr != null ){
            ListNode tail = curr;
            int count = 0;
            while ( curr != null && count < k){
                curr = curr.next;
                count++;
            }
            if (count != k){
                prev.next = tail;
            }else{
                prev.next = reverse(tail, k);
                prev = tail;
            }
            
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode head, int k){
        ListNode curr = head;
        ListNode prev = null;
        while ( curr != null && k-- > 0){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            
        }
        return prev;
    }
}
   
