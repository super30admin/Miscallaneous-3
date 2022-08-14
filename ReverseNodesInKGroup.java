//Time: O(N) | Space: O(1)

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
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode begin = dummyNode;
        int count = 0;
        while(head != null) {
            count++;
            if(count%k == 0) {
                begin = reverseKList(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummyNode.next;
    }
    private ListNode reverseKList(ListNode begin, ListNode end) {
        ListNode prev = begin;
        ListNode curr = begin.next;
        ListNode fast = begin.next.next;
        while(fast != end) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        ListNode firstNode = begin.next;
        begin.next.next = fast;
        begin.next = curr;
        return firstNode;

    }
}

// brute force
// space: O(K) | Time: O(N)

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> st = new Stack<>();
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curr = dummyNode.next;
        int count = 0;
        ListNode prevNode = dummyNode;
        while(curr != null) {
            st.push(curr);
            count++;
            if(count == k) {
                ListNode temp = st.pop();
                ListNode nextNode = temp.next;
                prevNode.next = temp;
                while(!st.isEmpty()) {
                    temp.next = st.pop();
                    temp = temp.next;
                }
                temp.next = nextNode;
                curr = temp;
                prevNode = temp;
                count = 0;
            }
            curr = curr.next;
        }
        return dummyNode.next;
    }
}