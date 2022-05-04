  class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        int n = nums.length;
        for(int i=0; i<n; i++)
        {
            int val = Math.abs(nums[i]);
            if(nums[val-1]<0)a.add(val);
            nums[val-1] = -nums[val-1];
        }
        return a;
    }
}
