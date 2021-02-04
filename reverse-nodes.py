# TIME COMPLEXITY: O(N)
# SPACE COMPLEXITY: O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:

    def reverse(self, prev, _next):
        last = prev.next
        curr = last.next

        while curr != _next:
            last.next = curr.next
            curr.next = prev.next
            prev.next = curr
            curr = last.next

        return last

    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        if not head or k == 1:
            return head

        fake = ListNode(0)
        fake.next = head
        prev = fake

        i = 0
        p = head

        while p:
            i += 1
            if i % k == 0:
                prev = self.reverse(prev, p.next)
                p = prev.next
            else:
                p = p.next

        return fake.next
