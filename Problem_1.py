#
# @lc app=leetcode id=1011 lang=python3
#
# [1011] Capacity To Ship Packages Within D Days
'''
Time Complexity - O(nlogk), k is the range of capacity of weight that can be transferred ranging from maximum weight in the list to the total sum of all the weights in the list.
Space Complexity - O(1)

Works on Leetcode
'''
# @lc code=start
class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        high = 0
        low = 0
        for wt in weights:
            low = max(low, wt)
            high += wt
        while low<=high:
            mid = low + int((high-low)/2)
            currDays = 1
            currSum = 0
            for i in range(len(weights)):
                #check if we can add the current weight to current lot
                if currSum+weights[i] > mid:
                    currSum = 0
                    currDays+=1
                currSum+=weights[i]
            #if number of days is greater than given days, cumulative parcel weight is higher. so we move low to mid+1
            if currDays > days:
                low = mid+1
            #else we move high to mid - 1 until we get days as that as given.
            else:
                high = mid - 1
        return low
        
# @lc code=end

