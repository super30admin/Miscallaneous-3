// Time Complexity : O(nlog(sum - max))  n = weights.size(), sum = sum of all weights, max = max weight
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// Approach: using Binary search on anwer range



class Solution {
public:
    bool possible(vector<int>& weights,int days, int w)
    {
        int c = 1;
        int sum = 0;
        for(int weight: weights)
        {
            if(sum+weight<=w)
            {
                sum+= weight;
            }
            else{
                c++;
                sum = weight;
            }
        }
        if(c<=days) return true;
        return false;
    }
    int shipWithinDays(vector<int>& weights, int days) {
        int n = weights.size();
        
        int lo = 0,hi = 0;
        for(int w: weights)
        {
            lo = max(lo,w);
            hi+= w;
        }
        
        int ans = n;
        
        while(lo<=hi)
        {
            int mid = lo +(hi-lo)/2;
            
            if(possible(weights,days,mid))
            {
                ans = mid;
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        
        return ans;
    }
};