class Solution {
    int dp[][];
    public int longestCommonSubsequence(String as, String bs) {
        dp = new int[as.length()+1][bs.length()+1];
        int al = as.length();
        int bl = bs.length();
        char a[] = as.toCharArray();
        char b[] = bs.toCharArray();
        for(int i=0; i<al+1; i++)
        {
            for(int j=0; j<bl+1; j++)
            {
                if(i==0||j==0)dp[i][j] = 0;
                else
                {
                    if(a[i-1]==b[j-1])
                    {
                        dp[i][j] = dp[i-1][j-1]+1;
                    }
                    else
                    {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return dp[al][bl];
    }
}
