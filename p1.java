// Time Complexity :O(log(range) * n) where range is max(weigths) to total of weigths
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int end = 0;
        int start = 0;
        for(int weight: weights){
            start = Math.max(start, weight);
            end += weight;
        }
        // System.out.println(start);
        // System.out.println(end);
//binary search to find the answer
        while(start <= end){
            int mid = start + (end-start)/2;
            int day = 1;
            int weight = 0;
            //To check how many days are required
            for(int i=0; i<weights.length; i++){
                weight += weights[i];
                if(weight > mid){
                    weight = weights[i];
                    day++;
                }
            }

            if(day <= days){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return start;
    }
}