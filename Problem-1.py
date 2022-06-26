class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        low=0
        high=0
        for w in weights:
            low=max(low,w)
            high+=w
        
        while low<=high:
            mid=low+(high-low)//2
            d=1
            currSum=0
            for i in range(len(weights)):
                if currSum + weights[i] > mid:
                    d+=1
                    currSum=weights[i]   
                    if d>days:
                        break
                else:
                    currSum+=weights[i]
            
            if d>days:
                low=mid+1
            else:
                high=mid-1
                
        return low
            
            
            