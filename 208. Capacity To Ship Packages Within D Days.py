class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        low = 0
        high = 0

        for weight in weights:
            low = max(low, weight)
            high += weight

        while low <= high:
            mid = low + (high - low) // 2
            d = 1
            currSum = 0

            for i in range(len(weights)):
                if weights[i] + currSum > mid:
                    d += 1
                    currSum = weights[i]
                    if d > days:
                        break
                else:
                    currSum += weights[i]

            if d > days:
                low = mid + 1
            else:
                high = mid - 1

        return low

# Binary Search
# Time Complexity :O(nlog(sum(weights) - max(n)))
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
