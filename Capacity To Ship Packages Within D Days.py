class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        # Time O(nlogk)
        # Space O(1)
        def daycheck(capacity):
            count = 1
            currwt = 0
            for i in weights:
                if (currwt + i) > capacity:
                    count += 1
                    currwt = 0
                currwt += i
            # print(capacity, count)
            return count

        total = sum(weights)
        low = max(weights)
        high = total
        # print("range", low, high)
        while low <= high:
            mid = low + (high - low) // 2
            if daycheck(mid) > days:
                low = mid + 1
            else:
                high = mid - 1
        return low
