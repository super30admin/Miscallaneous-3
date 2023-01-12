// TC - O(log(sum(n)-max(n))) * O(n)
// SC - O(1)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        // low will be max weight in the weights array
        // high will be sum of all weights in the weight array
        for (int wt : weights) {
            low = Math.max(low, wt);
            high += wt;
        }

        // perform binary search on low and high range
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int currDays = 1;
            int currWt = 0;
            for (int i = 0; i < weights.length; i++) {
                if (currWt + weights[i] > mid) {
                    currDays++;
                    currWt = 0;
                }
                currWt += weights[i];
            }
            if (currDays <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}