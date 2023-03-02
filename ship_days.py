# Time complexity: O(n*log(sum(wt)))
# Space complexity: O(1)

class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        def checker(val):
            x = 1
            curr = 0
            for i in range(len(weights)):
                if curr + weights[i] > val:
                    x += 1
                    curr = 0
                curr += weights[i]
            return x

        low = max(weights)
        high = sum(weights)
        print([i for i in range(low, high+1)])
        while low <= high:
            mid = (low + high)//2
            if checker(mid) > days:
                low = mid + 1
            else:
                high = mid - 1
            print(low, high, mid)
        return low
