//TC : O(Nlog(Sum of weights - maxWeight)
//SC : O(1)
class CapacityToShipPackages {
    public int shipWithinDays(int[] weights, int days) {

        int minCapacity = 0;
        int maxCapacity = 0;

        for(int weight : weights){
            minCapacity = Math.max(minCapacity, weight);
            maxCapacity = maxCapacity + weight;
        }

        int start = minCapacity;
        int end = maxCapacity;



        while(start <= end){
            int mid = start + (end - start)/2;
            int daysNeeded = 1; int currentWeight = 0;
            for(int weight : weights){
                if(currentWeight + weight > mid){
                    daysNeeded++;
                    currentWeight = 0;
                }
                currentWeight+=weight;
            }

            if(daysNeeded > days){
                start = mid +1;
            }
            else {
                end = mid -1;
            }

        }
        return start;
    }
}