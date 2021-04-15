class Solution:
    #Solution 1
    def shipWithinDays(self, weights: List[int], D: int) -> int:
        #Approach: Binary Search
        #Time Complexity: O(log(m) * n)
        #Space Complexity: O(1)
        #where, m is equal to the search space (max_limit - min_limit)
        #and, n is number of weights
        
        low = max(weights)
        high = sum(weights)
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if self.minDays(weights, mid) <= D:
                high = mid - 1
            else:
                low = mid + 1
                
        return low
    
    def minDays(self, weights, cap):
        days = 1
        curr = 0
        for weight in weights:
            if weight + curr > cap:
                days += 1
                curr = 0
            curr += weight   
        
        return days
    
    #Solution 2
    """
    def shipWithinDays(self, weights: List[int], D: int) -> int:
        #Approach: Linear Search
        #Time Complexity: O(m * n)
        #Space Complexity: O(1)
        #where, m is equal to the search space (max_limit - min_limit)
        #and, n is number of weights
        
        min_limit = max(weights)
        max_limit = sum(weights)
        
        for cap in range(min_limit, max_limit + 1):
            days = self.minDays(weights, cap)
            if days <= D:
                return cap
    
    def minDays(self, weights, cap):
        days = 1
        curr = 0
        for weight in weights:
            if weight + curr > cap:
                days += 1
                curr = 0
            curr += weight   
        
        return days
    """