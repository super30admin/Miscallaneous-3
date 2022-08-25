// Time Complexity :O(log(sum(n)-max(n)))*n
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
//do binary search from max of weight and sum of all weights ,calculate no of days and return min capacity where
//no of days remain equal or more than given
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        if (weights == null || weights.length == 0)
            return 0;
        int minCap = 0;
        int maxCap = 0;
        for (int i = 0; i < weights.length; i++) {
            minCap = Math.max(minCap, weights[i]);
            maxCap += weights[i];
        }
        int start = minCap;
        int end = maxCap;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int currCap = 0;
            int currDay = 1;
            for (int i = 0; i < weights.length; i++) {
                if (currCap + weights[i] > mid) {
                    currDay++;
                    currCap = 0;
                }
                currCap += weights[i];
            }
            if (currDay == days) {
                end = mid - 1;
            } else if (currDay > days) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}