# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reverseKGroup(self, head, k):
        if head == None or head.next == None:
            return head
        dummy = ListNode(-1)
        dummy.next = head
        begin = dummy
        i = 0
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

# Time Complexity : O(n)
# Space Complexity : O(1)