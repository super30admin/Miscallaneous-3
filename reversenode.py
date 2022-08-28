'''
time complexity: O(n)
space complexity: O(1)
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        
        dumy = ListNode(-1)
        dumy.next = head
        begin = dumy
        i=0
        while(head!=None):
            i+=1
            print("vals {} {}",i,head.val)
            if(i%k==0):
                print(i)
                print("1-",head.val)
                begin = self.reverse(begin,head.next)
                head = begin.next
                print("2-",head.val)
            else:
                head = head.next
        return dumy.next
        
    def reverse(self,begin,end):
        
        prev = begin
        curr = prev.next
        fast = curr.next
        
        while(fast!=end):
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
            
        curr.next = prev 
        first = begin.next
        begin.next.next = end
        begin.next = curr
        
        return first
        
        