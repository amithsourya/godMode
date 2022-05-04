class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int result = 0;
        while(right<n)
        {
            if(nums[right]-nums[left]<=0)
            {
                left = right;
            }
            else
            {
                result = Math.max(result, nums[right]-nums[left]);
            }
            right++;
        }
        return result;
  }
}
