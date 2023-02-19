# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(-1)
        dummy.next = head
        i = 0
        begin = dummy

        while head:
            i += 1
            if i % k == 0:
                begin = self.reverse(begin, head.next)
                head = begin.next
            else:
                head = head.next
        return dummy.next

    def reverse(self, begin, end):
        first = begin.next
        previous = begin
        curr = begin.next
        fast = curr.next
        while fast != end:
            curr.next = previous
            previous = curr
            curr = fast
            fast = fast.next

        # curr.next = previous
        # begin.next = curr
        # # first.next = end
        #   #OR
        # first.next = fast

        curr.next = previous
        begin.next.next = fast
        begin.next = curr

        return first

# Pointers
# Time Complexity : O(n)
# Space Complexity: O(1)