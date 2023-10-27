#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    int get_days(vector<int>& weights,int pred_wt){
        int day_count{};
        int sum_wts{};
        for(const int& w:weights){
            if((sum_wts + w)<=pred_wt){
                sum_wts +=w;
            }
            else{
                sum_wts = w;
                ++day_count;
            }
        }
        ++day_count;
        return day_count;
    }
    int shipWithinDays(vector<int>& weights, int days) {
        int min_capacity{0};
        int max_capacity{0};
        for(const int& w:weights){
            if(w>min_capacity){
                min_capacity = w;
            }
            max_capacity += w;
        }
        int low{min_capacity};
        int high{max_capacity};
        int mid{};
        while(low<high){
            mid = low + (high-low)/2;
            int day_count = get_days(weights,mid);
            if(day_count<=days){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
};