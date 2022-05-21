class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, result = 0;
        int left[] = new int[n];
        int right[] = new int[n];
        Stack<Integer> index = new Stack<>();
        for(int i=0; i<n; i++)
        {
            if(index.empty())
            {
                left[i] = 0;
                index.push(i);
            }
            else if(heights[index.peek()]<heights[i])
            {
                left[i] = i;
                index.push(i);
            }
            else
            {
                while(!index.empty()&&heights[index.peek()]>=heights[i])
                {
                    result = Math.max(result, heights[index.peek()]*(i-left[index.peek()]));
                    index.pop();
                }
                if(index.empty())left[i] = 0;
                else left[i] = index.peek()+1;
                index.push(i);
            }
        }
        while(!index.empty())
        {
            result = Math.max(result, heights[index.peek()]*(n-left[index.peek()]));
            index.pop();
        }
        return result;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length, result = 0;
        int heights[] = new int[n];
        for(int i=0; i<n; i++)heights[i] = 0;
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(matrix[i][j]=='0')heights[j] = 0;
                else heights[j] += 1;
            }
            result = Math.max(result, largestRectangleArea(heights));
        }
        return result;
    }
}
