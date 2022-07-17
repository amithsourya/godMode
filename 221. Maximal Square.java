class Solution {
    public int maximalSquare(char[][] matrix) {
        int dp[][] = new int[matrix.length+1][matrix[0].length+1];
        int result = 0;
        for(int i=0; i<dp.length; i++)
        {
            for(int j=0; j<dp[0].length; j++)
            {
                if(i==0||j==0||matrix[i-1][j-1]=='0')
                {
                    dp[i][j] = 0;
                }
                else
                {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])+1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result*result;
    }
}
