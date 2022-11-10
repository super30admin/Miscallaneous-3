// Time Complexity : O(log(sum(all weights) - max(weights))) * O(n) where n = length of weights array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//1011. Capacity To Ship Packages Within D Days (Medium) - https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
// Time Complexity : O(log(sum(all weights) - max(weights))) * O(n) where n = length of weights array
// Space Complexity : O(1)
class Solution {
	public int shipWithinDays(int[] weights, int days) {
		if (weights == null || weights.length == 0)
			return 0;

		int low = weights[0], high = 0;

		for (int weight : weights) { // O(n)
			low = Math.max(low, weight);
			high += weight;
		}

		while (low <= high) { // O(log(sum(n) - max(n))) * O(n)
			int mid = low + (high - low) / 2;
			int currDays = 1, currWeight = 0;

			for (int i = 0; i < weights.length; i++) {

				if (currWeight + weights[i] > mid) {
					currDays++;
					currWeight = 0;
				}
				currWeight += weights[i];
			}

			if (currDays <= days) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}
}