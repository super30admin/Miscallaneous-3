// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Reverse_K_Group {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head;
        ListNode start = dummy;
        int count = 1;

        while(curr != null){
            if(count % k == 0){
                start = reverse(start,curr.next);
                curr = start;
            }
            curr = curr.next;
            count++;
        }

        return dummy.next;
    }


    private ListNode reverse(ListNode start, ListNode end){
        ListNode first = start.next;

        ListNode curr = start.next;
        ListNode prev = start;

        while(curr != end ){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        start.next = prev;
        first.next = curr;

        return first;
    }

    /*private void display(ListNode start, ListNode end){
        System.out.println(" ");
        while(start!= end){
            System.out.print(start.val+" ");
            start = start.next;
        }
        System.out.print(start.val+" ");
    }*/
}