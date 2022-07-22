public class Problem1 {

    // TC : O (nlogk) where k = sum of ArrayElements - maxElements
    // SC : O (1)

    public int shipWithinDays(int[] weights, int days) {
        if (weights == null || weights.length == 0) return 0;

        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high = high + weight;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int day = 1;
            int sum = 0;

            for (int i = 0; i < weights.length; i++) {
                if (sum + weights[i] > mid) {
                    day++;
                    sum = weights[i];
                } else {
                    sum = sum + weights[i];
                }
            }

            if (day > days) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
