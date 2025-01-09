class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0,high=0;
        for(int wt:weights){
            low=Math.max(low,wt);
            high+=wt;
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            int currDays=1;
            int currWt=0;
            for(int wt:weights){
                currWt+=wt;
                if(currWt>mid){
                    currDays++;
                    currWt =wt;
                }
            }

            if(currDays<=days){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}