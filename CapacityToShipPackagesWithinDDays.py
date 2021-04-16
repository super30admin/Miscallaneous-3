# Time Complexity : O(NlogN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using nearest Binary Search


class Solution:
    def shipWithinDays(self, weights: List[int], D: int) -> int:
        if not weights:
            return None
        #get the maximum package weight in the ship since we cannot fragment the package
        #so that can be the minimum capacity of the ship
        left = max(weights)
        #total weights of all the packages
        right = sum(weights)

        #but since we need to ship 55 weight packages with max 10 weight package in 5 days
        #we need to have ship capacity range between 10 to 55
        #closest binary search
        while left <= right:
            mid = left + (right - left) // 2
            currDays = 1
            currSum = 0
            for i in range(len(weights)):
                if currSum + weights[i] > mid:
                    currSum = 0
                    currDays += 1
                currSum += weights[i]
            if currDays > D:
                left = mid + 1
            else:
                right = mid - 1

        return left
