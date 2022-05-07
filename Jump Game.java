class Solution {
    public boolean canJump(int[] nums) {
        if(nums[0]==0&&nums.length==1)return true;
        if(nums[0]==0)return false;
        int reachable = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(i>reachable)return false;
            reachable = Math.max(reachable, i+nums[i]);
        }
        return true;
    }
}
