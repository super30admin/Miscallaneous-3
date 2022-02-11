class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:              
        left, right = max(weights), sum(weights)
        ans=left
        while left <= right:
            mid = left + (right-left)//2
            if self.feasible(mid,weights,days):
                ans=mid
                right = mid-1
            else:
                left = mid + 1

        return ans
    
    def feasible(self,capacity,weights,days):
        local = 0
        for w in weights:
            local+=w
            if local>capacity:
                local = w
                days-=1
        if days<=0:
            return False
        return True
