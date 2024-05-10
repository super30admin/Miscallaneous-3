'''
TC: O(n+logn) - n for going through the weights and getting the sum and max
SC: O(1) - go through some pointers
'''
from typing import List

class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        
        def findDays(target):
            day = 0
            currSum = 0
            for weight in weights:
                currSum += weight
                if currSum > target:
                    currSum = weight
                    day += 1
            return day+1
        
        low = max(weights)
        high = sum(weights)
        while low < high:
            mid = (low+high)//2
            day = findDays(mid)
            if day > days:
                low = mid+1
            else:
                high = mid
        return high
s = Solution()
print(s.shipWithinDays([1,2,3,4,5,6,7,8,9,10], 5))
print(s.shipWithinDays([3,2,2,4,1,4], 3))
print(s.shipWithinDays([1,2,3,1,1], 4))