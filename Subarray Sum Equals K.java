class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int dp[] = new int[n+1];
        HashMap<Integer, Integer> hm = new HashMap<>();
        dp[0] = 0;
        hm.put(0, 1);
        int result = 0;
        for(int i=0; i<n; i++)
        {
            int val = nums[i]+dp[i];
            dp[i+1] = val;
            int search = val-k;
            if(hm.containsKey(search))
            {result += hm.get(search);
            System.out.println(search);}
            if(hm.containsKey(val))
            {
                hm.put(val, hm.get(val)+1);
            }
            else
            {
                hm.put(val, 1);
            }
        }
        return result;
    }
}
