# Time complexity: O(n)
# Space complexity:  O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        def reverse(begin, end):
            prev = begin
            curr = begin.next
            first = curr
            fast = curr.next
            while fast != end:
                curr.next = prev
                prev = curr
                curr = fast
                fast = fast.next
            curr.next = prev
            begin.next = curr
            first.next = end
            return first

        prev = ListNode()
        prev.next = head
        curr = head
        i = 0
        begin = prev
        while curr:
            i += 1
            if i % k == 0:
                begin = reverse(begin, curr.next)
                curr = begin.next
            else:
                curr = curr.next
        return prev.next
