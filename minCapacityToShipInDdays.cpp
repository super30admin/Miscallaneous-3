class Solution {
public:
    int shipWithinDays(vector<int>& weights, int D) {
        
        int low = 0;
        int high = 0;
        for (int i:weights) {
            low = max(i,low);
            high += i;
        }
       
        while (low <= high) {
            int mid = low + (high-low)/2;
            int currDays = 1;
            int currSum = 0;
            for (int i=0;i<weights.size();i++) {
                if (currSum+weights[i]>mid) {
                    currDays++;
                    currSum = 0;
                }
                currSum += weights[i];
            }
            //cout<<"mid: "<<mid<<" days: "<<currDays<<endl;
            if (currDays > D) {
                low=mid+1;
            } else {
                high=mid-1;
            }
        }
        return low;
    }
};