#
# @lc app=leetcode id=25 lang=python3
#
# [25] Reverse Nodes in k-Group
#

# @lc code=start
'''
Time Complexity - O(n)
Space Complexity - O(1)

Works on Leetcode
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        cnt = 0
        #We need a dummy node to point to head node
        dummy = ListNode(-1)
        dummy.next = head
        #We also need a pointer to indicate the current node
        curr = dummy
        begin = dummy #this will be the start node of group
        while curr.next!=None:
            #we continue until we do traverse k nodes 
            cnt+=1
            curr = curr.next
            if cnt%k==0:
                #When we cover k nodes we reverse the Linked List of k-nodes retianing the position of the node before the group and after the group
                begin = self.reverse(begin, curr.next)
                #We need one node before the actual start node of the group
                curr = begin
        return dummy.next
    
    def reverse(self, start, end):
        #start points the node before the first node in the group
        #end points to the node after the last node in the group 
        prev = start
        curr = start.next
        fast = curr.next
        #temp indicates first node in the group. It becomes the last after reversal and needs to point to end after reversing
        temp = curr
        while fast != end:
            #reversing a linked list
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        #In the end we have to make start point to the new first i.e. the last node in the group
        curr.next = prev
        start.next = curr
        #The first node in the group needs to point to the end, the end is the next node after the last node in the group
        temp.next = fast
        return temp
# @lc code=end

