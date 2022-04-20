package misc3;

public class CapacityToShipPackagesWithinDDays {
	//Time Complexity : O(n * log(high - low)), where n is length of weights array
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        
        for(int wt: weights) {
            low = Math.max(low, wt);
            high += wt;
        }
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int d = 1;
            int currWt = 0;
            for(int wt: weights) {
                if(currWt + wt > mid) {
                    d++;
                    currWt = 0;
                }
                currWt += wt;
            }
            
            if(d > days)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return low;
    }
}
