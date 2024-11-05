// Problem 1011. Capacity To Ship Packages Within D Days
// Time Complexity : O(N * log(sum(weights) - max(weights)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for (int wt : weights) {
            low = Math.max(low, wt);
            high += wt;
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            int d = 1;
            int currWt = 0;
            for (int i = 0; i < weights.length; i++) {
                if (currWt + weights[i] > mid) {
                    d++;
                    currWt = 0;
                }
                currWt += weights[i];
            }
            if (d > days) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}