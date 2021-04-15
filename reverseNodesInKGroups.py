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
        i = 0
        dummy = ListNode()
        dummy.next = head
        begin = dummy
        while head != None:
            i += 1
            if i % k == 0:
                begin = self.reverse(begin, head.next)
                head = begin.next 
            else:
                head = head.next
        return dummy.next
    def reverse(self, begin, end):
        prev = begin
        curr = begin.next 
        fast = curr.next 
        first = begin.next 
        while fast != end:
            curr.next = prev 
            prev = curr
            curr = fast
            fast = fast.next 
            
        curr.next = prev
        first.next = fast
        begin.next = curr
        return first