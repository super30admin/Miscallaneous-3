class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:

        ## T.C = O(n.log(total weight - max weight))

        low = 0
        high = 0

        for i in weights:
            low = max(low, i)
            high += i
        
        print(low, high)

        while low <= high:
            mid = (low + high) // 2

            dy = 1
            tot_wt = 0
            for wt in weights:
                if tot_wt + wt <= mid:
                    tot_wt += wt
                else:
                    dy += 1
                    tot_wt = wt
            
            if dy > days:
                low = mid + 1
            else:
                high = mid - 1
        
        return low
