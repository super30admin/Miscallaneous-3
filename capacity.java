// Time Complexity :O(log(sum(n)-max(n)))*n
// Space Complexity :constant
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