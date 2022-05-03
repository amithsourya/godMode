//Two pass
class Solution1 {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = 0;
        while(right!=nums.length)
        {
            if(nums[right]==0)
            {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
        right = left;
        while(right!=nums.length)
        {
            if(nums[right]==1)
            {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
    }
}
//Bucket Sort
class Solution2 {
    public void sortColors(int[] nums) {
        int count[] = new int[3];
        for(int i=0; i<3; i++)count[i] = 0;
        for(int x:nums)count[x]++;
        int index = 0;
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<count[i]; j++)nums[index++]=i;
        }
    }
}
