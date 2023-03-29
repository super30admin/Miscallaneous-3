/*
The question is asking:

We are given an array of objects with weights. 
We need to build a ship that hold the objects and ship them in days days.

Time: O(nlogn)
Space : o(1)
*/

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // we need to find the min weight and the sum of all weight

        int min = 0; // the miximum weight in the array
        int max =0; // the sum of all the weights in 

        for(int i=0;i<weights.length;i++){
            min = Math.max(min, weights[i]);
            max += weights[i];
        }

        // now since we have a maximum and minimum capacity that new ship needs to be build with
        // we can find the optimal capacity with binary search so that we can ship the weights in the 'days' day

        int low = min, high = max;

        while(low <= high){

            int mid =  (high +low) /2;
            // we will check if the mid cacapcity is the one

            int nDay =1;
            int currSum=0;
            int i=0;
             while(i<weights.length){
                 if(currSum+weights[i] <= mid){
                     currSum += weights[i];
                 }
                 else{
                     nDay++;
                     currSum=weights[i];
                 }
                 i++;
             }    

             if(nDay <= days){ // if we need more days, then we need to go lower
                 // we need to go lower
                 high = mid-1;
             }
             else{ // if we need less days, then we need to go higher
                 low = mid+1;
             }

        }

        return low;

    }
}