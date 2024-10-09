// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int totalWeight = 0;

        for (int weight : weights) {
            max = Math.max(max, weight);
            totalWeight += weight;
        }

        int low = max;
        int high = totalWeight;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int totalDays = noOfDays(weights, mid);
            if (totalDays <= days)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;

    }

    private int noOfDays(int[] weights, int weight) {
        int days = 1;
        int sum = 0;

        for (int i = 0; i < weights.length; i++) {
            if (sum + weights[i] > weight) {
                sum = 0;
                days++;
            }

            sum += weights[i];
        }

        return days;
    }
}