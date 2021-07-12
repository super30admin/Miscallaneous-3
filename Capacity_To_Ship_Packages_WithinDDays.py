class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        
        low , high = 0,0
        for weight in weights:
            low = max(low,weight)
            high += weight
        
        while low <= high:
            mid = low + (high -low) //2
            
            i = 0
            daystaken = 0
            currentcapacity = 0
            for weight in weights:
                if currentcapacity + weight > mid:
                    daystaken +=1
                    currentcapacity =0
                currentcapacity += weight
            
            if daystaken < days:
                high = mid -1
                
            else: 
                low = mid +1
            
        return low
