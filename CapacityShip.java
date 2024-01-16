// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class CapacityShip {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int wt: weights){
            low = Math.max(low,wt);
            high+=wt;
        }
        while(low < high){
            int mid = low + (high-low)/2;
            int currentDays = 1;
            int currentWeight = 0;
            for(int i = 0; i<weights.length; i++){
                if(currentWeight + weights[i] > mid){
                    currentWeight = 0;
                    currentDays++;
                }
                currentWeight+=weights[i];
            }
            if(currentDays > days){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
}