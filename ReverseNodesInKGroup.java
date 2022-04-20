package misc3;

public class ReverseNodesInKGroup {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		// null
		if(head == null || k <= 1)
			return head;

		ListNode res = new ListNode(-1);
		res.next = head;

		ListNode begin = res;
		int i = 0;
		while(head != null) {
			i++;
			if(i % k == 0) {
				begin = reverse(begin, head.next);
				head = begin.next;
			}
			else
				head = head.next;
		}

		return res.next;
	}

	private ListNode reverse(ListNode begin, ListNode end) {
		ListNode prev = begin;
		ListNode curr = begin.next;
		ListNode first = curr;
		ListNode fast = curr.next;
		while(fast != end) {
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
