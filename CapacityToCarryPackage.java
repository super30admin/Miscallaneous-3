//TC : O(n Log k) where n is the number of weights and k is sumofelements - maxelement
//SC : O(1)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0;
        int max = 0;
        for(int i : weights){
            min = Math.max(min,i);
            max += i;
        }
        int l = min;
        int r = max;

        while(r>=l){
            int mid = l +(r-l)/2;
            int n = calculateDays(weights,mid);
            //System.out.println("days: "+n+" for mid : "+mid);
            if(n>days)
                l = mid+1;
            else
                r = mid-1;
        }
        return l;
    }

    private int calculateDays(int[] weights, int cap){
        int count = 1;
        int capacity = 0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]+capacity>cap)
            {
                capacity = 0;
                count++;
            }
            capacity += weights[i];
        }
        return count;
    }
}