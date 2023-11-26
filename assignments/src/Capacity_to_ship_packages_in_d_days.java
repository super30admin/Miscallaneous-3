// Approach:
// 1. Binary search on 'lowest possible capacity to highest possible capacity'
// i.e. on the capacity range with currDays to decide to go to left half or right half.
// Time: O(n*log(range of capacity)) i.e. O(nlogn), range = sum(n) - max(n)
// Space: O(1)

class Capacity_to_ship_packages_in_d_days {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int wt : weights) {
            low = Math.max(low, wt);
            high = high + wt;
        }

        while(low <= high) {
            int currCapacity = low + (high - low) / 2;
            int currSum = 0;
            int currDays = 1;

            for (int wt : weights) {
                if (currSum + wt > currCapacity) {
                    currSum = 0;
                    currDays++;
                }
                currSum += wt;
            }

            if (currDays > days) {      // currCapacity is less
                low = currCapacity + 1;
            } else if (currDays <= days) {
                high = currCapacity - 1;
            }
        }
        return low;
    }
}