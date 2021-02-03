#Time Complexity : O(nlogk)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def shipWithinDays(self, weights: List[int], D: int) -> int:
        def isValid(weights, mid, D):
            days = 1
            s = 0
            for w in weights:
                s += w
                if s > mid:
                    days += 1
                    s = w
                if days > D:
                    return False
            return True

        mini = max(weights)
        maxi = sum(weights)
        while mini <= maxi:
            mid = (mini + (maxi-mini)//2)
            if isValid(weights, mid, D):
                maxi = mid - 1
            else:
                mini = mid + 1

        return mini
