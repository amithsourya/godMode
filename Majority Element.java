class Solution {
    public int majorityElement(int[] nums) {
        int res=0, count = 0;
        for(int x: nums)
        {
            if(count==0)
            {
                res = x;
                count = 1;
            }
            else
            {
                if(res==x)count++;
                else count--;
            }
        }
        return res;
    }
}
