//Time - O(log(sum(weights)-max(weights)))
//Space - O(!)
class Solution {
public:
    int shipWithinDays(vector<int>& weights, int D) {
        int left = 0, right = 0;
        for(int w:weights){
            left = max(left,w); 
            right += w;
        }
        
        
        while(left<right){
            int mid = (left+right)/2;
            int need = 1;
            int curr = 0;
            for(int i=0;i<weights.size() && need<=D;i++){
                if(curr + weights[i]>mid){
                    curr = 0;
                    need++;
                }
                curr = curr + weights[i];
            }   
            
            if(need>D){
                left = mid+1;
            } else{
                right = mid;
            }
        }
        return left;
    }
};