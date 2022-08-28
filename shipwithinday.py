'''
time complexity: O(sum(n)+max(n))logn
space complexity: O(1)
'''
class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        low = 0
        high = 0
        for i in range(len(weights)):
            low = max(low,weights[i])
            high += weights[i]
        
        
        while(low<=high):
            mid = (low + high) //2
            currSum = 0
            dayCount = 1
            for i in range(len(weights)):
                if currSum + weights[i] > mid:
                    dayCount+=1
                    currSum =0
                currSum+=weights[i]
            
            #if dayCount == days:
            #    high = mid -1
            if(dayCount > days):
                low = mid+1
                
            else:
                high = mid -1
        return low
                
            