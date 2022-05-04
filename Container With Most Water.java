class Solution {
    public int area(int left, int right, int[] height)
    {
        return (right-left)*Math.min(height[right], height[left]);
    }
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0, right = height.length -1;
        while(left<right)
        {
            result = Math.max(result, area(left, right, height));
            if(height[left]<height[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return result;
    }
}
