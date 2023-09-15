# Time Complexity : O(n)
# Space Complexity :O(1)
# Passed on Leetcode: yes

class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        def is_possible(capacity):
            days_required = 1
            current_weight = 0
            
            for weight in weights:
                if current_weight + weight <= capacity:
                    current_weight += weight
                else:
                    days_required += 1
                    current_weight = weight
                
                if days_required > days:
                    return False
            
            return True
        
        # Binary search for the minimum capacity
        left, right = max(weights), sum(weights)
        
        while left < right:
            mid = left + (right - left) // 2
            
            if is_possible(mid):
                right = mid
            else:
                left = mid + 1
        
        return left
