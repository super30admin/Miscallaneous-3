//time complexity: O(nlogn)
//space complexity: O(1)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=0;
        int sum=0;
        for(int i=0;i<weights.length;i++)
        {
            max=Math.max(max,weights[i]);
            sum+=weights[i];
        }
        int minCap=max;
        int maxCap=sum;
        while(minCap<=maxCap)
        {
            int numDays=0;
            int tempSum=0;
            int cap=minCap+(maxCap-minCap)/2;
            for(int i=0;i<weights.length;i++)
            {
                if(tempSum+weights[i]>cap)
                {
                    tempSum=0;
                    numDays+=1;
                }
                tempSum+=weights[i];
            }
            if(tempSum!=0)
                numDays+=1;
            if(numDays<=days){
                maxCap=cap-1;
            }
            else{
                minCap=cap+1;
            }
        }
        return minCap;
    }
}