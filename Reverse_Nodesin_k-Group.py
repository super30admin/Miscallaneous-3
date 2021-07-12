# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        
        if not head:
            return head
        
        i = 0
        dummy = ListNode(-1)
        dummy.next = head
        begin = dummy
        
        while head:
            i+=1
            if i %k ==0:
                begin = self.reverse(begin,head.next)
                head = begin.next
            else:
                head = head.next
                
        return dummy.next
    
    def reverse(self,begin,end):
        
        prev = begin
        curr = prev.next
        fast = curr.next
        first = begin.next
        while fast != end:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        
        curr.next = prev
        begin.next = curr
        first.next = end
        
        return first
