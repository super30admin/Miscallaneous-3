// Time Complexity : O(n * log (sum(n) - max(n)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class CapacityToShipPackages {

    public int shipWithinDays(int[] weights, int days) {
        int low = 0; int high = 0;
        for(int wt : weights){
            low = Math.max(low, wt);
            high += wt;
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            //calc days
            int currDays = 1;
            int currWt = 0;
            for(int wt : weights){
                if(currWt + wt > mid){
                    currDays++;
                    currWt = 0;
                }
                currWt += wt;
            }
            if(currDays > days){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}
