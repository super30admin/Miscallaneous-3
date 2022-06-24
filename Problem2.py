#Time Complexity: O(N)
#Space Complexity: O(N)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        count = 0
        dummy = ListNode(-1)
        dummy.next = head
        start = dummy
        while head != None:
            count +=1
            if (count%k == 0):
                start = self.reverse(start,head.next)
                head = start.next
            else:
                head = head.next
            
        return dummy.next
                
    def reverse(self,start,end):
        prev  = start
        curr = start.next
        fast = curr.next
        first = curr
        while fast!=end:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
         
        curr.next = prev
        start.next = curr
        first.next = end
        return first
            