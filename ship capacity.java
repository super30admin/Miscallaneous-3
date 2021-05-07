class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int low = 0;
        int high = 0;
        
        for(int weight: weights){
            low = Math.max(low, weight);
            high = high + weight;
        }
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            int currDays = 1;
            int currWeight = 0;
            
            for(int weight: weights){
                if (currWeight + weight > mid){
                    currDays = currDays + 1;
                    currWeight = 0;
                }
                currWeight = currWeight + weight;
            }
            
            if(currDays <= D){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}
