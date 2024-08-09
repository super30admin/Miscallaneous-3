// TC: O(N) * O((Sum of weights - max of weights) * log(Sum of weights - max of weights))
// SC : O(1)
public class Problem1 {
    public int shipWithinDays(int[] weights, int days) {
        int low =0,high=0;
        for(int i=0;i<weights.length;i++){
            low = Math.max(low,weights[i]);
            high += weights[i];
        }

        while(low <= high){
            int mid = low + (high-low)/2;
            int currDays = 1;
            int currWt = 0;

            for(int i=0;i<weights.length;i++){
                if(currWt + weights[i] > mid){
                    currDays++;
                    currWt = weights[i];
                }else{
                    currWt += weights[i];
                }
            }

            if(currDays <= days){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }
}
