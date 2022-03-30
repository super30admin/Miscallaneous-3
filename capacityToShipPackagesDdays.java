// Time Complexity :O(n log(max-min)), where n = no. of weights
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We perform a binary search to see if we get a number that is the minimum weight that the carrier needs to take in order to ship all the weights in given days
// We find the low and high to run binary search by iterating the weights by considering the maximum weight as the low, and the sum of all as max. This is because,
// consider if we take 1 weight a day, it will take the maximum weight also in 1 day, which means its the minimum capacity of the ship and
// if we take all the weights in 1 day we will have to add all the weights
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        if (weights == null || weights.length == 0) return 0;
        int low = 0, high=0;

        for (int i=0; i<weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }

        while (low <= high) {
            int mid = low + (high-low)/2;   // mid is the capacity of the ship
            int d = 1;
            int current = 0;
            for (int i=0; i<weights.length; i++) {
                if (current + weights[i] <= mid) {
                    current += weights[i];
                }
                else {
                    d++;
                    if (d > days) break;  // optimization: break if d crosses no. of days
                    current = weights[i];
                }
            }

            // binary search pointer manipulation
            if (d <= days) {    // it took less than alloted days, so we try to increase the days by decreasing the capacity/day
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }
}