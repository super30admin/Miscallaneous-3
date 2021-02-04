# TIME COMPLEXITY: O(N log (sum(weights)))
# SPACE COMPLEXITY: O(1)
class Solution(object):
    def shipWithinDays(self, weights, D):
        """
        :type weights: List[int]
        :type D: int
        :rtype: int
        """
        # Use binary search for optimization
        # Calculate range of capacities
        # The minimumum capacity of the ship has to be the max of the weights - we cannot break a weight
        start = max(weights)

        # The maximum capacity of the ship can be the sum of all the weights - all the packages can be shipped in one day
        end = sum(weights)

        # Use binary search to optimize the capacity
        while start <= end:
            mid = (start + end) // 2
            # Mid is the capacity, calulate the days required
            days = 1
            load = 0
            for i in range(len(weights)):
                # Keep loading weights till load < capacity
                load += weights[i]
                if load > mid:  # When load exceeds capacity, increase days by 1, set load to the current package weight
                    days += 1
                    load = weights[i]
            # Now if days required is greater than D, the cacpacity denoted by w is too low, search in range start + 1
            if days > D:
                start = mid + 1
            else:  # If the days required less than D, the capacity is too high, search in range end - 1
                end = mid - 1

        # At the end, start points at the optimum capacity to ship the packages in less than or equal to D days
        return start
