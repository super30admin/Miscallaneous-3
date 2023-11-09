#include<iostream>



struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    void display(ListNode*first){
        while(first!=NULL){
            cout<<first->val<<"->";
            first = first->next;
        }
        cout<<endl;
    }
    ListNode* reverse(ListNode* first,ListNode* last){
        ListNode* slow{};
        ListNode* fast{first};
        ListNode* temp{};
        while(fast!=last){
            temp = fast;
            fast = fast->next;
            temp->next = slow;
            slow = temp;
        }
        //display(slow);
        return slow;
    }
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(k==1) return head;
        ListNode* slow{head};
        ListNode* fast{head};
        ListNode* gg{};
        ListNode* temp{};
        int cnt{0};
        while(fast!=NULL || cnt%k==0){
            if(cnt!=0 && cnt%k==0){
                temp = reverse(slow,fast);
                if(gg == NULL){
                    head = temp;
                }
                else{
                    gg->next = temp;
                }
                gg = slow;
                slow->next = fast;
                slow = slow->next;
            }
            if(fast) fast = fast->next;
            ++cnt;
        }
        return head;
    }
};