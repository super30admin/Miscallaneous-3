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
//Time:O(N) where n is the number of nodes in the linked list
//Space: O(1)
class Solution {
public:
    ListNode* reverseGroup(ListNode* begin, ListNode* end){
        ListNode *prev = begin;
        ListNode *curr = prev->next;
        ListNode *first = curr;
        ListNode *fast = curr->next;
        while(curr->next != end){
            curr->next = prev;
            prev = curr;
            curr = fast;
            fast = fast->next;
        }
        curr->next = prev;
        first->next = fast;
        begin->next = curr;
        //cout<<curr->val;
        return first;
    }
    ListNode* reverseKGroup(ListNode* head, int k) {
        int i = 0;
        ListNode *dummy = new ListNode(-1);
        dummy->next = head;
        ListNode *begin = dummy;
        while(head){
            i++;
            if(i%k == 0){
                //reverse the group
                begin = reverseGroup(begin,head->next);
                head = begin->next;
            }
            else{
                head = head->next;
            }
        }
        return dummy->next;
    }
};