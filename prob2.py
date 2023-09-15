# Time Complexity : O(n)
# Space Complexity :O(1)
# Passed on Leetcode: yes

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        def reverseLinkedList(head, k):
            prev = None
            current = head
            
            # Reverse the first k nodes of the linked list
            for _ in range(k):
                next_node = current.next
                current.next = prev
                prev = current
                current = next_node
            
            return prev
        
        def getLength(head):
            length = 0
            while head:
                length += 1
                head = head.next
            return length
        
        # Calculate the length of the linked list
        length = getLength(head)
        
        dummy = ListNode(0)
        dummy.next = head
        prev_group_end = dummy
        
        while length >= k:
            group_start = prev_group_end.next
            group_end = group_start
            
            # Find the end of the current group
            for _ in range(k - 1):
                group_end = group_end.next
            
            next_group_start = group_end.next
            group_end.next = None  # Disconnect the current group
            
            # Reverse the current group
            prev_group_end.next = reverseLinkedList(group_start, k)
            group_start.next = next_group_start
            
            prev_group_end = group_start
            length -= k
        
        return dummy.next
