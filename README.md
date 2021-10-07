# Misc-3

## Problem 1: Capacity to ship packages in d days (https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/)
//time complexity = n * log(arr(sum) - max(arr))
//space complexity = O(1)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0; 
        int high = 0; 
        
        for(int i = 0; i < weights.length; i++){
            low = Math.max(low,weights[i]); 
            high += weights[i]; 
        }
        
        while(low <= high){
            int mid = low + (high - low) / 2; 
            int count = 1; 
            int currSum = 0; 
            for(int i = 0; i < weights.length; i++){
                if(currSum + weights[i] > mid){
                    count++; 
                    currSum = weights[i]; 
                }else{
                    currSum += weights[i]; 
                }
            }
            if(count <= days){
                high = mid - 1;
            }else{
                low = mid + 1; 
            }
        }
        
        return low;
    }
}

## Problem 2: Reverse nodes in k groups (https://leetcode.com/problems/reverse-nodes-in-k-group/)
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

//Time complexity = O(N)
//Space complexity = O(1)
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        
        ListNode dummy = new ListNode(-1); 
        dummy.next = head; 
        ListNode begin = dummy;
        int i = 0; 
        
        while(head != null){
            i++;
            if(i % k == 0){
                begin = reverse(begin,head.next); 
                head = begin.next;
            }else{
                head = head.next;
            }
        }
        
        return dummy.next; 
    }
    
    private ListNode reverse(ListNode begin, ListNode end){
        ListNode prev = begin;
        ListNode curr = begin.next;
        ListNode fast = curr.next;
        ListNode first = curr; 
        
        while(fast != end){
            curr.next = prev; 
            prev = curr;
            curr = fast;
            fast = fast.next; 
        }
        
        curr.next = prev; 
        begin.next = curr;
        first.next = fast; 
        return first; 
    }
}
