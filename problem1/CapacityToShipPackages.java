// Time Complexity : O(nlog(range)), n -> Number of packages, range -> Difference between min and max capacities
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class CapacityToShipPackages {
	public int shipWithinDays(int[] weights, int days) {
		if (weights == null || weights.length == 0) {
			return 0;
		}

		int maxCap = 0;
		int minCap = 0;

		for (int weight : weights) {
			minCap = Math.max(minCap, weight);
			maxCap += weight;
		}

		int low = minCap;
		int high = maxCap;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			int numDays = countDays(weights, mid);

			if (numDays <= days) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}

	private int countDays(int[] weights, int capacity) {
		int numDays = 1;
		int currWeight = 0;

		for (int weight : weights) {
			if (currWeight + weight <= capacity) {
				currWeight += weight;
			} else {
				currWeight = weight;
				numDays++;
			}
		}

		return numDays;
	}

	public static void main(String[] args) {
		CapacityToShipPackages obj = new CapacityToShipPackages();
		int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int days = 5;

		System.out.println("Least Weight Capacity: " + obj.shipWithinDays(weights, days));
	}

}
