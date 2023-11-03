//Problem 1: Capacity To Ship Packages Within D Days
// Time Complexity : O(n)+O(log(sum(n)-min(n)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// maximum day range is sum of all weights (ship in mimimum days) to minimum weight, takes maximum days to ship.
//Once u get this, just do binary search on this range. 
class Solution {
    //O(n)+O(log(sum(n)-min(n)))
    public int shipWithinDays(int[] weights, int days) {
        int low=0, high=0;
        for(int wt: weights){
            low=Math.min(low,wt);
            high+=wt;
        }

        while(low<=high){
            int mid= low+(high-low/2);
            //check how many days we take at mid;
            int curDays=1, Curwt=0;
            for(int i=0;i<weights.length;i++){
                if(Curwt+weights[i]> mid){
                    curDays++;
                    Curwt=weights[i];
                }else{
                    Curwt= Curwt+ weights[i];
                }
            }

            if(curDays>days){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
}

//Problem 2: Reverse nodes in k groups
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// try to start with the whole packet, means one extra on left and right this will help connection with next nodes.
lass Solution {
    //O(n)
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur=head, dummy=new ListNode(-1);
        dummy.next=head;
        ListNode st=dummy;
        int count=1;

        while(cur!=null){
            if(count%k==0){
                st=rev(st, cur.next);
                cur=st;
            }
            count++;
            cur=cur.next;
        }
        return dummy.next;
    }

    private ListNode rev(ListNode start, ListNode end){
        ListNode prev=start, cur=start.next, fast=cur.next;
        ListNode first=cur;
        while(fast!=end){
            cur.next=prev;
            prev=cur;
            cur=fast;
            fast=fast.next;
        }
        cur.next=prev;
        first.next=end;
        start.next=cur;
        return first;
    }
}