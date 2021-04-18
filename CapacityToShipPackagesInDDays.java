//Binary Search
//TC: O(N*K), N: no. of weights, K: (maxCapacity - minCapacity) of ship
//SC: O(1)
//Did it run successfully on Leetcode?:Yes
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        if ( weights == null || weights.length == 0)
            return 0;
        int low = 0;
        int high = 0;
        for (int weight : weights){          // find out the min and max capacity of ship
            low = Math.max(low, weight);     // min capacity should be max weight
            high = high + weight;            // max capacity should be sum of all weights
        }
        //IMP trick: binary search on the possible capacities of ship (not weights array)
        while ( low <= high){        //O(maxCpacity - minCapacity)
            int mid = low + (high-low)/2;   // mid -> current capacity of ship
            int currSum = 0;
            int currDays = 1;
            for (int weight : weights){  //TC: O(N)
                if (currSum + weight > mid ){      //if incoming weight + currSum is greater than the current capacity, then increase the cuurDaya by 1 and reset the currSum to 0
                    currSum = 0;
                    currDays++;
                }
                currSum = currSum + weight;
            }
            if (currDays > D){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }             
         }
     return low;
   }
}
