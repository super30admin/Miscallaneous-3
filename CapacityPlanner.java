public class CapacityPlanner {
    public int shipWithinDays(int[] weights, int days) {
        // TC : O(n * log n)
        // SC : O(1)
        if(weights == null || weights.length == 0) return 0;

        int low =0, high  = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high = high + weight;
        }

        while(low <= high) {
            int mid = low + (high - low)/2;
            int Days = 1;
            int currSum = 0;

            for(int weight : weights) {
                if(currSum + weight > mid) {
                    Days++;
                    currSum = weight;
                    if(Days > days) break;
                }else {
                    currSum = currSum + weight;
                }
            }

            if(days >= Days) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return low;
    }

}
