class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int maximum = Integer.MIN_VALUE, sum = 0;
        
        // The ship should have a minimum capacity of the maximum element in the array.
        // The maximum ship capacity could be the sum of the array.
        for(int weight : weights)
        {
             maximum = Math.max(maximum, weight);
             sum += weight;
        }

        int low = maximum, high = sum;

        // Assume for array 1 2 3 ... 10 low is 10 and high is 55. We need to find out the least weight capacity
        // Apply binary search between these two end points
        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            int req_days = func(weights, mid);

            // If this case is satisfied this means that the result we found out has a larger capacity lets go to the
            // left part of the array to get the least capacity.
            if(req_days <= days) high = mid - 1;
            
            // This case will execute when capacity is not sufficient then we should go to the more capacity so move 
            // right
            else low = mid + 1;
        }

        // Assume we imagine the end points as 10 11 12 13 14 ... 55. We know that the least capacity is 15. From 15
        // till 55 all capacities will give us 5 days or less than that. But from 10 to 14 these capacities are less 
        // and are not sufficient. So we started low at 10 which was not sufficient and high at 55 which was sufficient.
        // And now the while loop is broken it means low has crossed high. That means high has now come to a position
        // where capacity is not sufficient and low is at the position which has capacity to handle the weights in 5 days.
        // So low is now pointing to 1st least capacity. Return this.
        return low;
        
    }

    private int func(int[] weights, int capacity)
    {
        int day = 1, load = 0;

        for(int i = 0; i < weights.length; i++)
        {
            if(load + weights[i] <= capacity) load += weights[i];

            else
            {
                day += 1;
                load = weights[i];
            }
        }

        return day;
    }
}