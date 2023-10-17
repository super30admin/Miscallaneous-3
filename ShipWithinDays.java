// Time Complexity : O(log((maxCap - minCap)*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int minCap = 0, maxCap = 0;
        for(int wt: weights)
        {
            minCap = Math.max(minCap,wt);
            maxCap += wt;
        }
        int low = minCap; int high = maxCap;
        while(low <= high){                         //O(log((maxCap - minCap)*n))
            int mid = low + (high - low)/2;
            int sum = 0;
            int count = 1;

            for(int i=0; i<weights.length; i++){
                sum += weights[i];
                if(sum > mid){
                    count++;
                    sum = weights[i];
                }
            }
            if(count > days){
                low = mid+1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}