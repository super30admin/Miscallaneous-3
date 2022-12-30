// Time Complexity:O(n) + O(log(running sum - max value in weights))
// Space Complexity: O(1)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        if(weights == null || weights.length == 0) return 0;

        int low = 0;
        int high = 0;

        for(int wt: weights) {
            low = Math.max(low, wt);
            high = high + wt;
        }

        while (low <= high) {
            int mid = low + (high-low)/2;
            int Days = 1;
            int sum = 0;
            for (int i=0; i < weights.length; i++) {
                if (sum + weights[i] <= mid) {
                    sum += weights[i];
                } else {
                    sum = weights[i];
                    Days++;
                }
            }

            if (Days > days) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}