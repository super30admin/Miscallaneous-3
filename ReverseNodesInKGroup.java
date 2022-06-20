//Time Complexity O(N)
//Space ComplexityO(1)
//LeetCode tested

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count=0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next!=null){
            temp=temp.next;
            count++;
        }
        temp=dummy;
        while (temp.next!=null){
            if(count<k) break;
            int nodes = k-1;
            ListNode tempNext = temp.next;
            ListNode first = temp.next;
            ListNode second = first.next;
            while (nodes-- >0){
                ListNode next = second.next;
                second.next = first;
                first=second;
                second=next;
            }
            count-=k;
            temp.next = first;
            tempNext.next = second;
            temp=tempNext;
        }
        return dummy.next;
    }
}
