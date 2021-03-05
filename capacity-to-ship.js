// TIme, Space - O(NlgN), O(1)
/**
 * @param {number[]} weights
 * @param {number} D
 * @return {number}
 */

var shipWithinDays = function(weights, D) {
    let low = Number.MIN_VALUE;
    let high = 0;
    
    for(let weight of weights) {
        high += weight;
        low = Math.max(weight, low);
    }
    
    
   
    
    while(low < high) {
        let mid = low + Math.floor((high - low) / 2);
        
        if(isBSValid(mid, weights, D)) {
            high = mid;
        }
        else {
            low = mid + 1;    
        }
    }
    
    return low;
    
};

function isBSValid(mid, weights, D) {

    let days = 0;
    let sum = 0;
    for(let i=0;i<weights.length;i++) {
        sum += weights[i];
        if(sum > mid) {            
            days++;
            sum = weights[i];
            if(days>=D) {
                return false;
            }
        }
    }
    return true;
}
