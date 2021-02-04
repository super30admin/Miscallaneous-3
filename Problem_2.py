"""
Time Complexity : O(n)- each node would be traversed max 2 times 
Space Complexity : O(1)  
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Here, we would reverse in batches.
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        if not head:
            return head
        dummy = ListNode(-1, head)
        begin = dummy
        i = 0
        while head:
            i += 1
            if not i % k:
                begin = self.reverse(begin, head.next)
                head = begin.next
            else:
                head = head.next
        return dummy.next

    def reverse(self, begin, end):
        prev = begin
        curr = begin.next
        fast = curr.next
        first = curr
        while fast != end:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        begin.next = curr
        first.next = fast
        return first
