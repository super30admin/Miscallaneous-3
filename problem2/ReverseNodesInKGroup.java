// Time Complexity : O(n), n -> Number of nodes in the list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k <= 1) {
			return head;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode begin = dummy;
		int cnt = 0;
		ListNode curr = head;

		while (curr != null) {
			cnt++;
			if (cnt % k == 0) {
				begin = reverseKNodes(begin, curr.next);
				curr = begin.next;
			} else {
				curr = curr.next;
			}
		}

		return dummy.next;
	}

	private ListNode reverseKNodes(ListNode begin, ListNode end) {
		ListNode prev = begin;
		ListNode curr = begin.next;
		ListNode fast = curr.next;
		ListNode first = begin.next;

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

	private void print(ListNode head) {
		ListNode temp = head;

		while (temp.next != null) {
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.println(temp.val);
	}

	public static void main(String[] args) {
		ReverseNodesInKGroup obj = new ReverseNodesInKGroup();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		System.out.println("List: ");
		obj.print(head);
		System.out.println("Reversed List: ");
		ListNode reversedHead = obj.reverseKGroup(head, 3);
		obj.print(reversedHead);
	}

}
