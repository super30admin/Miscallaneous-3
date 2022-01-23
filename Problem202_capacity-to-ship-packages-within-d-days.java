// Time Complexity: O(n * log(sum(n) - max(n))) -> n = weights
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for(int wt : weights) {
            low = Math.max(low, wt);
            high += wt;
        }
        while(low <= high) {
            int mid = low + (high - low) / 2;
            // mid capacity
            // how many needed at this capacity
            int d = 1;
            int currSum = 0;
            for(int i = 0; i < weights.length; i++) {
                if(currSum + weights[i] > mid) {
                    d += 1;
                    currSum = weights[i];
                } else {
                    currSum += weights[i];
                }
                if(d > days) break;
            }
            if(d > days) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}