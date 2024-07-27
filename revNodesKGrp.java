
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
 * class Solution {
 * public ListNode reverseKGroup(ListNode head, int k) {
 * //Tc: O(n) Sc: O(1)
 * ListNode dummy = new ListNode(-1);
 * dummy.next = head;
 * int cnt = 0;
 * ListNode begin = dummy;
 * while (head != null) {
 * cnt++;
 * if (cnt % k == 0) {
 * begin = reverse(begin, head.next);
 * head = begin;
 * }
 * head = head.next;
 * }
 * return dummy.next;
 * }
 * 
 * private ListNode reverse(ListNode begin, ListNode end) {
 * ListNode prev = begin;
 * ListNode cur = begin.next;
 * ListNode fast = cur.next;
 * while (fast != end) {
 * cur.next = prev;
 * prev = cur;
 * cur = fast;
 * fast = fast.next;
 * }
 * cur.next = prev;
 * ListNode first = begin.next;
 * first.next = fast;
 * begin.next = cur;
 * return first;
 * }
 * }
 * 
 */