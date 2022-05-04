class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);
        int result = 0;
        int x = 0;
        for(int i: nums)
        {
            x += i;
            x %= k;
            if(x<0)x+=k;
            if(m.containsKey(x))
            {
                int val = m.get(x);
                result += val;
                m.put(x, val+1);
            }
            else
            {
                m.put(x, 1);
            }
        }
        return result;
    }
}
