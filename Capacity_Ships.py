# Time complexity : O(n*log(sum of weights + max wt))
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        # we need to find the low and high values which is the range in order to find the minimum weight
        high, low = 0, 0
        for i in range(len(weights)):
            low = max(low, weights[i])
            high += weights[i]
        
        # do a binary search over the range of values from low to high
        while(low <= high):
            # find the mid element using low and high
            mid = low + (high - low) // 2
            
            # check if we are able to ship the packages within the given days
            day = 1
            wts = 0
            for i in range(len(weights)):
                if wts + weights[i] > mid:
                    day += 1
                    wts = 0
                wts += weights[i]
            
            # if the days we find are less than move then range from low to mid
            if day <= days:
                high = mid - 1
            else:
              # else range will be from mid to high
                low = mid + 1
        
        # return the lowest value for which the above condition satisfies
        return low
