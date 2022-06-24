#Time Complexity: O(NlogN)
#Space Complexity: O(1)
class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        low = 0
        high = 0
        for i in weights:
            low = max(low,i)
            high += i

        
        while low <= high:
            mid = low + (high - low)//2
            curr = weights[0]
            total = 1
            for i in range(1,len(weights)):
                if curr + weights[i] > mid:
                    total +=1
                    curr = 0
                
                curr += weights[i]
                
            if total <= days:
                high = mid -1
            else:low = mid + 1
                
        return low