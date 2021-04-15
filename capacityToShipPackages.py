class Solution:
    def shipWithinDays(self, weights: List[int], D: int) -> int:
        left = max(weights)
        right = 0
        
        for i in range(len(weights)):
            right += weights[i]
            
     
        # left = leastCapacity
        # right = maxCapacity
        
        while left <= right:
            #mid is the capacity
            mid = left + (right-left)//2
            currSum = 0
            days = 1
            for i in range(len(weights)):
                if currSum + weights[i] > mid:
                    currSum = 0
                    days += 1
                currSum += weights[i]
                
            if days > D:
                left = mid + 1
            else:
                right = mid-1
                
        return left