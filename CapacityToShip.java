//Time: O(Log(Sum(weights)-Max(weights)) * N) | Space: O(1)

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int weight: weights) {
            high += weight;
            low = Math.max(low, weight);
        }
        while(low <= high) {
            int mid = low+(high-low)/2;
            int currCap = 0;
            int noOfDays = 0;
            for(int i=0;i<weights.length;i++) {
                currCap += weights[i];
                if(currCap > mid) {
                    currCap = weights[i];
                    noOfDays++;
                }
            }
            noOfDays++;
            if(noOfDays > days) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return high+1;
    }
}