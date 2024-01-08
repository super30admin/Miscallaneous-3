// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        if(weights == null || weights.length == 0)
            return 0;
        int low = 0;
        int high = 0;
        for(int w : weights){
            low = Math.max(low, w);
            high += w;
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            int currDays = 1;
            int currSum = 0;
            for(int i = 0; i < weights.length; i++){
                if(currSum + weights[i] > mid){
                    currDays++;
                    currSum = 0;
                }
                currSum += weights[i];
            }
           if(currDays > days){
               low = mid + 1;
           } else {
               high = mid - 1;
           }
        }
        return low;
    }
}