// Time Complexity : O(nlogn)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        if(weights == null || weights.length ==0){
            return 0;
        }
        int low = 0;
        int high = 0;
        for(int wt:weights){
            low = Math.max(low, wt);
            high += wt;
        }

        while(low <= high){
            int mid = low + (high - low) / 2;
            int d = 1;
            int wt = 0;
            for(int i =0; i< weights.length; i++){
                if(wt + weights[i] <= mid){
                    wt += weights[i];
                }
                else{
                    d++;
                    wt = weights[i];
                }
            }
            if(d <= days){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}