"""
Time Complexity : O(nlogk) where n is the length of weights array and k is the range, ie max(weights)- sum (weights)
Space Complexity : O(1)  
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Here, instead of working on the array, we work on capacity. The minimum capacity the ship can have is the maximum weight possible
if each shipment had to be sent on individual days. The maximum capacity could be the sum of all the shipments in case we plan
on sending all the shipments on a single day. So, we got our min and max capacity. Now, we do a binary search on our capacity
to find out which capacity can send the packages in D days. To calculate the number of days, we iterate through the array and 
calculate the weights. 
"""


class Solution:
    def shipWithinDays(self, weights: List[int], D: int) -> int:
        low = max(weights)
        high = sum(weights)
        while low <= high:
            totalDays = 1
            currWt = 0
            mid = low + (high-low)//2
            for w in weights:
                currWt += w
                if currWt > mid:
                    currWt = w
                    totalDays += 1
            if totalDays > D:
                low = mid+1
            else:
                high = mid-1
        return low
