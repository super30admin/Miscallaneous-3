// time, space - O(N), O(1)
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function(head, k) {
    if(head === null || k === 0) {
        return head;
    }
    
    let dummy = new ListNode(-1);
    dummy.next = head;
    let begin = dummy;
    let end = head;
    let i = 0;
    while(head !== null) {
        i++;
        if(i%k === 0) {
            begin = reverse(begin, head.next);
            head = begin.next;
        }
        else {
            head = head.next;
        }
    }
    
    return dummy.next;
    
};

var reverse = function(begin, end) {
    
    let cur = begin.next;
    let prev = begin;
    let fast = cur.next;
    let first = cur;
    while(fast!== end) {
        cur.next = prev;
        prev = cur;
        cur = fast;
        fast = fast.next;
    }
    cur.next = prev;
    first.next = fast;
    begin.next = cur;
    return first;
    
}
