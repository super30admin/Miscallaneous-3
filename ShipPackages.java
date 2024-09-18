// LC 1011

/**
 * The least possible capacity can be the max. weight and the max capacity can be the sum of all weights.
 * So, the answer lies within this range which is sorted --> apply BS
 *
 * and check if the probable ans satisfies the given days.
 *
 * Discard halves based on the premise that if it takes <= days, then it means we are picking a greater capcity.
 * So, reduce the range -> hi = mid - 1,
 * else , lo = mid + 1
 */
public class ShipPackages {

    /**
     * TC: O(n * log(W))
     * W = sum of all weights
     * @param weights
     * @param days
     * @return
     */
    public int findMinCapacity(int[] weights, int days) {
        int lo = weights[0];
        int hi = 0;
        for(int weight : weights) {
            lo = Math.max(lo, weight);
            hi += weight;
        }
        int mid, ans = lo;
        while(lo <= hi) {
            mid = lo + (hi - lo)/2;

            int day = 1;
            for(int i = 0, wt = 0; i < weights.length && day <= days; i++) {
                if(wt + weights[i] <= mid) {
                    wt += weights[i];
                } else {
                    wt = weights[i];
                    day++;
                }
            }

            // it is taking less days than required -> we have a higher capacity --> decrease it
            if(day <= days) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}
