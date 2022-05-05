class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++)
        {
            if(i>0 && nums[i]==nums[i-1])continue;
            int left = i+1;
            int right = nums.length-1;
            while(left<right)
            {
                int sum = nums[i]+nums[left]+nums[right];
                if(sum<0)
                {
                    left++;
                }
                else if(sum>0)
                {
                    right--;
                }
                else
                {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);             
                    res.add(temp);
                    left++;
                    while(left<nums.length && nums[left]==nums[left-1])left++;
                }
            }
        }
        return res;
    }
}
