//Time Complexity: O(nlogm); where n= total number of weights and m = sum(weights) - max(weights).
//Space Complexity: O(1)

public class CapacityToShipPackages {
	/**Approach: Binary Search**/	
	public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int weight: weights){
            low = Math.max(low, weight);
            high += weight;
        }
        //Binary search from low to high and check how many days mid capacity takes     
        while(low <= high){
            int mid = low +(high-low)/2;
            int count=1;
            int capacity = 0;             
            for(int weight: weights){
                if(capacity+weight > mid){                    
                    count++;
                    capacity = 0;                    
                }                 
                capacity += weight;
            }            
            if(count <= days) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
	
	/** Driver code to test above **/
	public static void main (String[] args) {			
		CapacityToShipPackages ob  = new CapacityToShipPackages();
		int[] weights = {1,2,3,4,5,6,7,8,9,10}; 
		int days = 5;
								
		System.out.println("Min weight capacity of the ship :"+ob.shipWithinDays(weights, days)); 
	}	
}
