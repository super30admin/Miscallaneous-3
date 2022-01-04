/*

Worked on LC : YES
Time complexity : N Log(N) 
Space complexity : O(1)

*/


class Solution {
    public int shipWithinDays(int[] weights, int days) {
        List<Integer> intList = new ArrayList<Integer>(weights.length);
        for (int i : weights){ intList.add(i);}
        
//      minimum weights that can be transmitted in ship
        int minPtr = Collections.max(intList);
        int maxptr=0;
        
        for(int wi : weights) {
            maxptr+=wi;
        }
        
        int result = maxptr;
        while(minPtr <= maxptr) {
            
            int mid = (minPtr + maxptr) /2;
            
//              check for mid
            // is it feasible to trasnmit all goods in d days if we choose to have minimum capacity of mid 
            // if yes we can check for lower value than current best if not we will check for higher value than current candidate
            if(isFeasible(weights, mid, days)) {
                result = mid;
                maxptr = mid-1;
            }else{
                minPtr = mid+1;
            }
            
            
        }
        
        return result;
        
        
    }
    
    
    boolean isFeasible(int [] weights, int maxptr, int days) {
        int capacity = maxptr;
        int totalDays = 1;
        int i=0;
        int n=weights.length;
        while(i<n){
            if(weights[i]<= capacity) {
                capacity-=weights[i];
                i++;
            }else{
                capacity = maxptr;
                totalDays++;
            }
        }
        
        return totalDays<= days;
        
    }
}
