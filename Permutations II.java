class Solution {
    int n;
    ArrayList<List<Integer>> result;
    HashMap<Integer, Integer> hm;
    public void solve(int k, int[]a)
    {
        if(k==n)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int x: a)temp.add(x);
            result.add(temp);
            return;
        }
        for(int x: hm.keySet())
        {
            if(hm.get(x)>0)
            {
                a[k] = x;
                hm.put(x, hm.get(x)-1);
                solve(k+1, a);
                hm.put(x, hm.get(x)+1);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<List<Integer>>();
        hm = new HashMap<Integer, Integer>();
        n = nums.length;
        for(int num: nums)
        {
            if(hm.containsKey(num))hm.put(num, hm.get(num)+1);
            else hm.put(num, 1);
        }
        int [] temp = new int[n];
        solve(0, temp);
        return result;
    }
}
