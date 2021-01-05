/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    
    int total(ListNode *start)
    {
        int count=0;
        while(start!=NULL)
        {
            start=start->next;
            count++;
        }
        return count;
    }
    
    ListNode* reverseKGroup(ListNode* head, int k) 
    {
        if(head==NULL)
            return head;
        
      ListNode *prev=NULL,*curr=head,*next_node=NULL;
        
        int len=total(head);
            
        if(k>len)
            return head;
        
        int count=k;
        while(curr!=NULL && count>0)
        {
            next_node=curr->next;
            curr->next=prev;
            prev=curr;
            curr=next_node;
            count--;
        }
        
        if(next_node!=NULL)
        {
            head->next=reverseKGroup(next_node,k); 
        }
        
        return prev;
    }
};