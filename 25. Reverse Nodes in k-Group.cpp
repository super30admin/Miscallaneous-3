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
    ListNode* reverse(ListNode* head, int k){
      int i = 0;
      stack<ListNode*> st;
      while(i<k){
        if(head==nullptr)  return nullptr;
        st.push(head);
        head = head->next;
        i++;
      }

      ListNode* next = head;
      ListNode* ret = st.top();
      ListNode* curr = ret;
      st.pop();

      while(!st.empty()){
        curr->next = st.top();
        curr = curr->next;
        //cout<<st.top()->val<<endl;
        st.pop();
      }

      curr->next = next;
      return ret;
    }

    ListNode* kNext(ListNode* head, int k){
      int i = 0;
      while(i<k-1){
        if(head==nullptr)  return head;

        head = head->next;
        i++;
      }
      
      return head;
    }
    ListNode* reverseKGroup(ListNode* head, int k) {

      ListNode* rotatedHead = reverse(head,k);
      if(rotatedHead != nullptr){
        head = rotatedHead;
      }

      ListNode* tail = kNext(head,k);

      while(tail!=nullptr){
        cout<<tail->val<<endl;
        rotatedHead = reverse(tail->next,k);
        tail->next = rotatedHead == nullptr ? tail->next : rotatedHead;
        tail = kNext(tail->next,k);
      }
      


      return head;

    }
};
