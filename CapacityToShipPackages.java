class Solution {

    //Time Complexity: 0(nlogk) where n is the no. of elements in weights and n = sum of elements - max weight
    //Space Complexity: 0(1)

    public int shipWithinDays(int[] weights, int days) {
        if(weights == null || weights.length == 0){
            return 0;
        }

        int low = 0;    //I am doing a binary search so high and low
        int high = 0;

        for(int weight : weights){  //going over all the weights
            low = Math.max(low, weight);    //I am setting my low to highest weight in my array because the capacity has to be atleast the highest weight otherwise it can't carry the load
            high = high + weight;   //I am setting my high to the sum of all the weights
        }

        while(low <= high){     //I begin my BS
            int mid = low + (high - low) / 2;   //calculate low
            int day = 1;    //Calculate days required to ship all the packages taking capacity as mid
            int sum = 0;    //to calculate the capacity the ship can transport in 1 day
            for(int i = 0; i < weights.length; i++){    //going over the length of array
                if(sum + weights[i] > mid){ //if the current weight and prev sum is greater than capacity
                    day++;  //then I increase my day as it has to be transported the next day
                    sum = weights[i];   //also I reset my sum to current weight
                }
                else{
                    sum = sum + weights[i]; //Else I just keep on adding the weight till it reaches capacity
                }
            }

            if(days >= day){    //Now I do BS. If the given days is greater, then I can decrease the capacity
                high = mid - 1;
            }
            else{   //otherwise, I will increase my capacity
                low = mid + 1;
            }
        }

        return low; //at the end I will return low
    }
}