# Misc-3

## Problem 1: Capacity to ship packages in d days (https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/)

// Time - Comlexity = O(N\*log(range))
//Space - Complexity = O(1)
class Solution {
public int shipWithinDays(int[] weights, int days) {
if(weights == null || weights.length == 0) {
return 0;
}
int min = 0;
int max = 0;

        for(int weight : weights) {
            min = Math.max(min, weight);
            max +=weight;
        }

        int low = min;
        int high = max;

        while(low <= high) {
            int mid = low + (high-low) / 2;
            int count = countDays(weights,mid);

            if(count <= days) {
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int countDays(int[] weights, int capacity) {
        int count = 1;
        int currentSum = 0;

        for(int i = 0 ; i < weights.length; i++) {
            if(currentSum + weights[i] <= capacity) {
                currentSum += weights[i];
            } else {
                currentSum = weights[i];
                count++;
            }
        }
        return count;
    }

}

## Problem 2: Reverse nodes in k groups (https://leetcode.com/problems/reverse-nodes-in-k-group/)

// Time - Comlexity = O(N)
//Space - Complexity = O(1)

/\*\*

- Definition for singly-linked list.
- public class ListNode {
-     int val;
-     ListNode next;
-     ListNode() {}
-     ListNode(int val) { this.val = val; }
-     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
- }
  \*/
  class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
  if(head == null || k <= 1) {
  return head;
  }
          ListNode dummy = new ListNode(-1);
          dummy.next = head;
          ListNode begin = dummy;
          int count = 0;
          ListNode current = head;

          while(current != null) {
              count++;
              if(count % k == 0) {
                  begin = reverseKNodes(begin,current.next);
                  current = begin.next;
              } else {
                  current = current.next;
              }
          }

          return dummy.next;
      }

      private ListNode reverseKNodes(ListNode begin, ListNode end) {
          ListNode prev = begin;
          ListNode current = begin.next;
          ListNode fast = current.next;
          ListNode first = begin.next;

          while(fast != end) {
              current.next = prev;
              prev = current;
              current = fast;
              fast = fast.next;
          }
          current.next = prev;
          begin.next = current;
          first.next = fast;

          return first;

      }
  }
