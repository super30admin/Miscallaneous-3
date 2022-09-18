""""// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(-1)
        dummy.next = head
        begin = dummy
        i = 0
        while (head != None):
            i += 1
            if (i % k == 0):
                begin = self.reverse(begin, head.next)
                head = begin.next

            else:
                head = head.next
        return dummy.next

    def reverse(self, begin, end):

        prev = begin
        curr = prev.next
        fast = curr.next

        while (fast != end):
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next

        curr.next = prev
        first = begin.next
        begin.next.next = end
        begin.next = curr

        return first
