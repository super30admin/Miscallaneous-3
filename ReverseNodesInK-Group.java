// Time Complexity : O(n) where n = number of elemens in linked list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//25. Reverse Nodes in k-Group (Hard) - https://leetcode.com/problems/reverse-nodes-in-k-group/
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
// Time Complexity : O(n) where n = number of elemens in linked list
// Space Complexity : O(1)
class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		int count = 0;
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode begin = dummy;

		while (head != null) { // O(n)
			count++;

			if (count % k == 0) {
				begin = reverse(begin, head.next);
				head = begin.next;
			} else {
				head = head.next;
			}
		}

		return dummy.next;
	}

	private ListNode reverse(ListNode begin, ListNode end) {
		ListNode first = begin.next;
		ListNode prev = begin;
		ListNode curr = begin.next;
		ListNode fast = curr.next;

		while (fast != end) {
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