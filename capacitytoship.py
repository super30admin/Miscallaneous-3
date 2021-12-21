"""
https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
"""


class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        """
        tc -###O(n*log(sum(weights)-max(weights)))
        sc - o1
        """
        n = len(weights)
        high = sum(weights)
        low = max(weights)
        while low <= high:  ###O(n*log(sum(weights)-max(weights)))
            mid = (low + high) // 2
            ##middle capacity now try this for how many days needed at this capacity
            currdays = 1
            currsum = 0
            for i in range(len(weights)):
                if currsum + weights[i] > mid:
                    currdays += 1
                    currsum = weights[i]
                else:
                    currsum += weights[i]

            if currdays > days:
                ##days are more we need to reduce days and if we reduce days then capacity needs to be increased
                low = mid + 1
            else:
                ###days are less we need more days, if we get more days capacity needs to be reduced

                high = mid - 1

            ###low always ending at the right position

        return low

        """
         [1,2,3,4,5,6,7,8,9,10]
         low=10
         high=55
         we will do the binary search on the capacity array [10,11,12,13,....55]
         we will find the middle, at 25 we see how many days required and so on
        """


