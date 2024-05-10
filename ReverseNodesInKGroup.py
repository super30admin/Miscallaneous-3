'''
TC: O(n) - Number of nodes in the linked list
SC: O(1) - in-place reverse so no additional space is required
'''
# Definition for singly-linked list.
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        
        #find the group end
        def findGroupEnd(node):
            pointer = node
            count = -1
            while pointer:
                count += 1
                if count == k:
                    return pointer
                pointer = pointer.next
            return None

        #reverse group
        def reverseGroup(first, end):
            nextNode = end.next
            tail = None
            while first.next!=nextNode:
                newhead = first.next
                first.next = newhead.next
                newhead.next = tail
                if not tail:
                    finaltail = newhead
                tail = newhead
            finaltail.next = nextNode
            first.next = tail
            return finaltail
            

        dummy = ListNode(-1, head)
        first = dummy
        while first:
            end = findGroupEnd(first)
            if end:
                first = reverseGroup(first, end)
            else:
                return dummy.next
        return dummy.next
s = Solution()
print(s.reverseKGroup([1,2,3,4,5], 2))
print(s.reverseKGroup([1,2,3,4,5], 3))