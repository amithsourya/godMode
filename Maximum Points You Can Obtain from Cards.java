class Solution {
    public int front(int dp[], int index)
    {
        if(index==0)return 0;
        return dp[index-1];
    }
    public int back(int dp[], int index)
    {
        if(index==0)return 0;
        return dp[dp.length-index];
    }
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int dp[] = new int[n];
        int dpb[] = new int[n];
        dp[0] = cardPoints[0];
        dpb[n-1] = cardPoints[n-1];
        for(int i=1; i<n; i++)
        {
            dp[i] = dp[i-1]+cardPoints[i];
        }
        for(int i=n-2; i>0; i--)
        {
            dpb[i] = dpb[i+1]+cardPoints[i];
        }
        int sum = dp[n-1];
        int result = 0;
        for(int i=0; i<=k; i++)
        {
            result = Math.max(result, front(dp, i)+back(dpb, k-i));
        }
        return result;
    }
}
