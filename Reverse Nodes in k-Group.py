# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        #Approach: Iterative
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        #where, n is the number of nodes in the list
        
        if k == 1:
            return head
        
        dummy = ListNode(-1, head)
        left = last = dummy
        for i in range(k):
            last = last.next
        
        flag = True
        while flag:
            first = left.next
            right = last.next
            last.next = None
            
            revList = self.reverse(first)
            left.next = revList
            first.next = right
            
            last = first
            for i in range(k):
                if not last.next:
                    flag = False
                    break
                
                left = left.next
                last = last.next
        
        return dummy.next
        
    def reverse(self, root):
        prev = None
        
        while root:
            temp = root.next
            root.next = prev
            prev = root
            root = temp
            
        return prev