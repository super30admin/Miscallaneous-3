public class CapacityToShipPackagesWithinDdays {
    /**
     Time complexity - o(nlog(sum of all elements + max of all elements));
     Space complexity - o(1)
     Approach:
     We decided to do binary search between sum of all elements  and  max of all
     elements to find the exact package weight to send in given number of days.

     we start wit high as sum of all elements
     low as max of all elements
     compute middle.
     with middle as the capacity, iterate through array, adding 1 day for each time we reached capacity(mid)
     if we crossed number of days, we need to increase weight.
     for that we need to increase low.

     if we had more days after calculating enite array, then we can reduce weight. for that we lower high.

     we stop this as soon as we reach low is high. and return low.

     */
    public int shipWithinDays(int[] weights, int days) {
        if (weights == null || weights.length == 0) {
            return 0;
        }
        int low = 0;
        int high = 0;
        for (int wt : weights) {
            low = Math.max(low, wt);
            high = high + wt;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2; // prevent integer overflow
            // mid is weight carrying capacity;
            int d = 1;
            int wt = 0;
            for (int i = 0; i < weights.length; i++) {
                if (wt+weights[i] <= mid) {
                    wt = wt + weights[i];
                } else {
                    d++;
                    wt = weights[i];
                }
            }
            if (d <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;

    }
}
