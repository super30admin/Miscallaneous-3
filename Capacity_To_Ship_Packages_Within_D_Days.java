class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        
        for(int wt : weights){
            low = Math.max(low, wt); 
            high += wt; 
        }
        
        while(low<= high){
            int mid  = low + (high - low)/2; 
            int currDays  = 1;
            int currWt = 0;
            
            
            //days required at this capacity
            for(int i  =0; i <weights.length; i++){
                if(currWt + weights[i] > mid){
                    currDays++;
                    currWt = 0;
                }
                currWt += weights[i]; 
                    
            }
        
        if(currDays > days){
            low = mid + 1;
        }else{
            high = mid -1;
        }
    }
        return low;
            
    }
}

//TC: O(N * log(arraysum - max(arr)))
//SC: O(1)
