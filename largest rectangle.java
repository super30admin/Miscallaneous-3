// Time Complexity - O(n)
// space Complexity - O(n) - stack max size could be n in worst case
// works on leetcode 

class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        while(i < heights.length){
            if(stack.peek() == -1 || heights[i] > heights[stack.peek()]){
                stack.push(i);
                i = i + 1;
            }
            else{
                int top = stack.pop();
                max = Math.max(max, heights[top] * (i - stack.peek() - 1));
            }
        }
        
        while(stack.peek()!=-1){
            int top = stack.pop();
            max = Math.max(max, heights[top] * (i - stack.peek() - 1));
        }
        
        return max;
    }
}
