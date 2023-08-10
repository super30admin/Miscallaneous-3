// Time Complexity : O(n)  n = no. of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;
        int count = 0;
        ListNode* prev = dummy;
        ListNode* begin = dummy;
        while(head!=NULL)
        {
            count++;
            if(count%k==0)
            {
                begin = reverseHead(begin,head->next);
                head = begin;
            }
            head = head->next;
        }
        
        return dummy->next;
    }
    ListNode* reverseHead(ListNode* begin,ListNode* end)
    {
        //beginNode-> firstnode-> .......-> lastNode-> endNode
        // we should change order of nodes from firstNode to lastNode only.
        
        ListNode* nextbegin = begin->next;
        
        ListNode* prev = begin;
        ListNode* curr = begin->next;
        
        while(curr!=end) 
        {
            ListNode* temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }
        // now prev is the lastNode address
        
        
       //  now connect ends properly
        begin->next = prev;
        nextbegin->next = end;
        
        return nextbegin;
        
        
        
    }
    
};