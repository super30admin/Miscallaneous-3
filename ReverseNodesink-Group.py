# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        if not head:
            return None

        dummy = ListNode(-1)
        dummy.next = head

        begin = dummy
        i = 0
        while head:
            i += 1
            if i % k == 0:
                begin = self.reverse(begin, head.next)
                head = begin.next
            else:
                head = head.next
        return dummy.next

    def reverse(self, begin, end):
        prev = begin
        currNode = prev.next
        fast = currNode.next
        first = currNode
        while fast != end:
            currNode.next = prev
            prev = currNode
            currNode = fast
            fast = fast.next

        currNode.next = prev
        first.next = end
        begin.next = currNode
        return first
