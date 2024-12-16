// Logic -
// the minimum capacity will be the max of the weights 
// the max capacity wll be the sum of all the weights
// So the range is max(weights) to sum(weights)
// and so we do the binary search over the range. changing the capacity each time. depending on the no. of days taken on that capacity.
// no. of days * capacity/day = total no. of weights
// Time complexity = O(nlog(m)).n is the weights array length and m is the range.
//  space complexity = O(1)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high = 0;
        for(int weight: weights) {
            low = Math.max(low, weight);
            high+= weight;
        }
        
        while(low<=high ) {
            int mid = low + (high-low)/2;
            int d=1;
            int currWt =0;
            for(int i=0;i< weights.length;i++) {
                
                if(currWt+ weights[i] > mid) {
                    d++;
                    currWt = 0;
                }
                currWt += weights[i];
            }
            if(d> days) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }
}