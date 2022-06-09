// Time Complexity : O(N) where N is the no. of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Take prev and after end nodes in some variable and reverse the in-between k nodes
// Later attach them. Keep doing this untill we are left with nodes less than k
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
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        ListNode beforeCur = dummy;
        while(cur != null){
            ListNode end = cur;
            for(int i = 0; i < k-1; i++){
                end = end.next;
                if(end == null)
                    break;
            }
            if(end == null)
                break;
            ListNode afterEnd = end.next;
            reverse(cur, end);
            beforeCur.next = end;
            cur.next = afterEnd;
            beforeCur = cur;
            cur = afterEnd;
        }
        return dummy.next;
    }
    public void reverse(ListNode cur, ListNode end){
        ListNode prev = null;
        ListNode ending = end.next;
            while(cur != ending){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
    }
}