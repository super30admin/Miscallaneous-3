public class CapacityToShipPackages {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int wt:weights){
            low = Math.max(low,wt);
            high+=wt;
        }

        while(low<=high){
            int mid = low+ (high-low)/2;
            int currDays = 1;
            int currWt = 0;
            for(int i=0;i<weights.length;i++){
                if(currWt + weights[i] > mid){
                    currDays++;
                    currWt = 0;
                }
                currWt += weights[i];
            }
            if(currDays<=days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}

// TC - O(log(sum(n)-max(n))*O(n)
// SC - O(1)