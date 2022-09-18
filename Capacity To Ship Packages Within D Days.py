""""// Time Complexity : O(n* log(sum(n)-max(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""

class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        low = 0
        high = 0
        for i in range(len(weights)):
            low = max(low, weights[i])
            high += weights[i]

        while (low <= high):
            mid = (low + high) // 2
            currSum = 0
            dayCount = 1
            for i in range(len(weights)):
                if currSum + weights[i] > mid:
                    dayCount += 1
                    currSum = 0
                currSum += weights[i]

            if dayCount <= days:
                high = mid - 1
            else:
                low = mid + 1
        return low