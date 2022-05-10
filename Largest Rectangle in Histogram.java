//2 pass
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
                    index.pop();
                }
                if(index.empty())left[i] = 0;
                else left[i] = index.peek()+1;
                index.push(i);
            }
        }
        while(!index.empty())index.pop();
        for(int i=n-1; i>=0; i--)
        {
            if(index.empty())
            {
                right[i] = n-1;
                index.push(i);
            }
            else if(heights[index.peek()]<heights[i])
            {
                right[i] = i;
                index.push(i);
            }
            else
            {
                while(!index.empty()&&heights[index.peek()]>=heights[i])
                {
                    index.pop();
                }
                if(index.empty())right[i] = n-1;
                else right[i] = index.peek()-1;
                index.push(i);
            }
        }
        for(int i=0; i<n; i++)
        {
            result = Math.max(result, heights[i]*(right[i]-left[i]+1));
        }
        return result;
    }
}
//1 pass
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
}
