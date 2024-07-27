class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // Tc: O(n) Sc: O(1)
        int tSum = 0;
        int maxWt = 0;
        for (int i = 0; i < weights.length; i++) {
            tSum += weights[i];
            maxWt = Math.max(maxWt, weights[i]);
        }

        int left = maxWt;
        int right = tSum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (feasible(mid, days, weights)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean feasible(int i, int days, int[] weights) {
        int day = 1;
        int tot = 0;
        for (int w : weights) {
            tot += w;
            if (tot > i) {
                day++;
                tot = w;
            }
        }
        return day <= days;
    }
}

/*
 * class Solution {
 * public int shipWithinDays(int[] weights, int days) {
 * // Tc: O(n^2) Sc: O(1)
 * int tSum = 0;
 * int maxWt = 0;
 * int ans = Integer.MAX_VALUE;
 * for (int i = 0; i < weights.length; i++) {
 * tSum += weights[i];
 * maxWt = Math.max(maxWt, weights[i]);
 * }
 * 
 * for (int i = maxWt; i <= tSum; i++) {
 * if (feasible(i, days, weights)) {
 * ans = Math.min(ans, i);
 * }
 * }
 * return ans;
 * }
 * 
 * private boolean feasible(int i, int days, int[] weights) {
 * int day = 1;
 * int tot = 0;
 * for (int w : weights) {
 * tot += w;
 * if (tot > i) {
 * day++;
 * tot = w;
 * }
 * }
 * return day <= days;
 * }
 * }
 * 
 */