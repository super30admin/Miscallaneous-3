# Time complexity - O(nlog(m))
# low = max of the weights 
# high = sum of the weights
class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        low = high = 0
        for num in weights:
            low = max(low, num)
            high += num
        
        while (low <= high):  # O(log(m))
            mid = low + (high - low)//2
            d = 1
            cur_wt = 0
            for num in weights: # O(n)
                if cur_wt + num > mid: 
                    d += 1
                    cur_wt = 0
                cur_wt += num
            if d > days:
                low = mid + 1
            else:
                high = mid - 1
        return low
