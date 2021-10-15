class Solution(object):
    def shipWithinDays(self, weights, days):
        if weights == None or len(weights) == 0 or days == 0:
            return 0
        low = 0
        high = 0
        for i in range(len(weights)):
            low = max(low, weights[i])
            high += weights[i]
            
        while low <= high:
            mid = low + (high-low) // 2
            currSum = 0
            count = 1
            for i in range(len(weights)):
                if currSum + weights[i] > mid:
                    count += 1
                    currSum = weights[i]
                else:
                    currSum += weights[i]
                    
            if count <= days:
                high = mid -1
            else:
                low = mid + 1
                
        return low



# Time Complexity: O(n * log(sum(weights) - max(weights))     
# Space Complexity: O(1)
                
            