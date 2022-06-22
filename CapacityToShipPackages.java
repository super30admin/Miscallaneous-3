//TC : O[ n * log(sum(weights) - max(weights) ) ]
//Sc : O(1)

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        
        for(int w : weights){
            low = Math.max(low, w);
            high += w;
        }
        
        //Doing closest binary search on range of the Capacity
        
        while(low <= high){//Log(high - low) time 
            int mid = low + (high - low)/ 2;
            
            int tempDays = 1;
            int wts = weights[0];
            for(int i = 1; i< weights.length; i++){ //O(N)
                if(wts +weights[i] > mid){ 
                    tempDays++;
                    wts = 0;
                }
                wts += weights[i];   
            }
            if(tempDays <= days){
                high = mid - 1;
            }else   low = mid + 1;
        }
        return low;
    }
}
