// Brute: (sum n - max n) * n 
// Using Binary Search below: log(sum n - max n) * n
// Doing binary search on the range of the capacities
// Space: O(1)
// Executed Sucessfully: Yes

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < weights.length; i++){
            min = Math.max(min, weights[i]);
            max += weights[i];
        }

        
        while (min <= max){
            int mid = min + (max - min)/2;
            int res = 0;
            int count = 0;
            for(int j = 0; j < weights.length; j++){
                if (count + weights[j] > mid){  
                    res++;
                    count = 0;
                }
                count += weights[j];
                
            }
            res++;
            if (res == days){
                max = mid - 1;
            }else if (res > days){
                min = mid + 1;
            }else{
                max = mid - 1;
            }
            
        }
        
        return min;
    }
}
