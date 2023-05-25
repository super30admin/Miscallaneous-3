/*
Capacity to ship packages in d days
approach: we can see that if 1 day is given we need to ship total sum and
if we're given [1,10] & days = 2, the potential minimum would be 10 which is the maximum of the array,
so we got the range of minimum capacity which is [min potential, total sum], so brute force is we do linear search in found range.
optimized is binary search.
time: O(log [min potential, total sum])
space: O(1)
 */
public class Problem1 {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0, sum = 0;
        for (int n:weights) {
            max = Math.max(max, n);
            sum+=n;
        }
        int start = max, end = sum;

        while (start<=end) {
            int mid = (start+(end-start)/2);

            if (check(weights, mid, days)) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }

        return start;
    }

    private boolean check(int[] weights, int limit, int dayslimit) {
        int sum = 0;
        int days = 1;
        for (int n:weights) {
            sum+=n;
            if (sum>limit) {
                sum = n;
                days++;
                if (days>dayslimit) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        problem1.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 3);
    }
}
