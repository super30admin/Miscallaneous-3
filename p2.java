// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

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
        if(k ==1) return head;
        ListNode start = head;
        ListNode end = head;
        ListNode nextStart = head;
        ListNode nextEnd = head;
        ListNode result = head;
        boolean flag = false;
        boolean isEnd = false;
        while(!isEnd){
            start = nextStart;
            end = nextStart;
            int count = 1;
            while(end.next != null && count != k){
                end = end.next;
                count++;
            }
            if(end.next != null){
                nextStart = end.next;
                nextEnd = end.next;
                int nxtcount = 1;
                while(nextEnd.next != null && nxtcount != k){
                    nextEnd = nextEnd.next;
                    nxtcount++;
                }
                if(nxtcount != k){
                    nextEnd = end.next;
                    isEnd = true;
                }
            }else{
                isEnd = true;
                nextEnd = null;
            }
            if(count == k){
                if(!flag){
                    result = end;
                    flag = true;
                }
                reverse(start, end);
                start.next = nextEnd;
                
            }
            
        }

        return result;
    }

    private void reverse(ListNode start, ListNode end){
        ListNode prev = null;
        ListNode curr = start;
        ListNode temp = start.next;

        while(prev != end){
            curr.next = prev;
            prev = curr;
            curr = temp;
            if(temp != null)temp = temp.next;
        }
    }
}