class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0; 
        int high = 0;
        for(int wt: weights){
            low = Math.max(low, wt);
            high = high + wt;
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            int currCap = weights[0];
            int currDays = 1;
            for(int i = 1; i < weights.length; i++){
                if(weights[i] + currCap > mid){
                    currDays++;
                    currCap = 0;
                }
                currCap += weights[i];
            }
            if(currDays > days){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
}
