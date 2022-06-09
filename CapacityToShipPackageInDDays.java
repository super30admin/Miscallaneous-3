// Time Complexity : (n log k) where n is the length of weights array and k is the dif of max and min possible capacity
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Min possible capacity would be maxValue of a weight and max capacity would be sum of all weight
// Our answers would be among these two and all the values in between them.
// We will do binary search on this range and check if the value is validCapacity
// To check for validCapacity we add the weights sequencially and check how many trips/days are needed
// If the days needed is less than equal the given in the input, it means its validCapacity 
// After the binary seach we will have be able to find the min valid capacity and we will return it
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minPossibleWeightCapacity = 0;
        int maxPossibleWeightCapacity = 0;;
        for(int weight: weights){
            minPossibleWeightCapacity = Math.max(minPossibleWeightCapacity, weight);
            maxPossibleWeightCapacity += weight;
        }
        int low = minPossibleWeightCapacity;
        int high = maxPossibleWeightCapacity;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(capacityPossible(mid, weights, days)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean capacityPossible(int capacity, int[] weight, int days){
        int coveredDays = 1;
        int curWeight = 0;
        for(int i = 0; i < weight.length; i++){
            if((curWeight + weight[i]) > capacity){
                curWeight = weight[i];
                coveredDays++;
            }
            else{
                curWeight += weight[i];    
            }
            if(coveredDays > days)
                return false;
        }
        return coveredDays <= days;
    }
}