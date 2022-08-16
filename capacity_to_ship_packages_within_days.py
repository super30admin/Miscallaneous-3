# Time Complexity :O( R * N) N is number of parcels to ship, R is sum(N) - max(N) i.e. range of weight of parcels cap
# Space Complexity :O(N) N is length of the string
# Did this code successfully run on Leetcode : No (Time Limit Exceeded)
# Any problem you faced while coding this : No


class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        if len(weights) == 0: return 0
        
        minW = max(weights)
        maxW = sum(weights)
        for cap in range(minW, maxW + 1):
            currCap = 0
            sDays = 1
            for w in weights:
                if currCap + w > cap:
                    currCap = 0
                    sDays += 1
                
                currCap += w
                
                
            if sDays <= days:
                return cap
            
        
        return maxW