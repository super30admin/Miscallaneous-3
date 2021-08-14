//Time:O(nlogn) where n is the number of weights
//Space: O(1) no extra space
class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        //sort(weights.begin(),weights.end());
        int low = INT_MIN,high;
        for(auto &weight : weights){
            low = max(low,weight);
            high+=weight;
        }
        
        while(low <= high){
            int mid = low + (high-low)/2;
            int total = 0;
            int day = 1;
            for(auto weight : weights){ 
                if(total + weight > mid){
                    day++;
                    total = 0;
                }
                total += weight;
            }
            //cout<<day<<endl;
            //if(day == days) return mid;
            if(day > days){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }
};