//Time - O(n)
//Space - O(1)
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(k<2 || head == NULL) return head;
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* begin = dummy;
        
        int i = 0;
        while(head!=NULL){
            i++;
            if(i%k == 0){
                begin = reverseIt(begin, head->next);
                head = begin->next;
            }else{
                head = head->next;
            }
        }

        return dummy->next;
    }
    
    ListNode* reverseIt(ListNode* begin, ListNode* end){
        ListNode* prev = begin;
        ListNode* head = prev->next;
        ListNode* first = head;
        ListNode* n = head->next;
        while(n!=end){
            n = head->next;
            head->next = prev;
            prev = head;
            head = n;
        }
        first->next = end;
        begin->next = prev;
        return first;
    }
};