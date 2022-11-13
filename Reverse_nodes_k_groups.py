# Time complexity : O(n)
# Space complexity :  O(1)
# Leetcode : Solved and submitted

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
      
        # create a dummy node, and make it the head
        dummy = ListNode(-1)
        dummy.next = head
        begin = dummy
        
        # start the count with 0
        count = 0
        
        # traverse until head is not None
        while head is not None:
           # increment the count for each node
            count += 1
            
            # if count is divisible by k then reverese the list between begin which is the dummy node at first and the k+1 th node
            if count % k == 0:
                # after reversing the list, begin becomes my first element of the original list which is last after reversing
                begin = self.reverse(begin, head.next)
                
                # head becomes the next element of new begin node
                head = begin.next
            else:
                # otherwise increment the head node
                head = head.next
        
        return dummy.next
    
    def reverse(self, begin, end):
        # store the first node in a variable as that is to be returned
        first = begin.next
        
        # we need 3 pointers prev, curr and fast to reverse a list
        prev = begin
        curr = begin.next
        fast = curr.next
        
        # traverse the list until we reach the end
        while fast != end:
          
          # break the old links and make new ones, and move the pointers by one
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        
        # at the end, make the required links and return the first node
        curr.next = prev
        first.next = fast
        begin.next = curr
        
        return first
