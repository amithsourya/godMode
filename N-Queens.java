class Solution {
    public static char[][] a ;
    static List<List<String>> res = new ArrayList<List<String>>();
    public static boolean isValid(int i, int j, int n)
    {
        int row = i-1, col = j-1;
        while(row>=0&&col>=0)
        {
            if(a[row][col]=='Q')return false;
            row--;
            col--;
        }
        row = i;
        col = j-1;
        while(col>=0)
        {
            if(a[row][col]=='Q')return false;
            col--;
        }
        row = i+1;
        col = j-1;
        while(row<n&&col>=0)
        {
            if(a[row][col]=='Q')return false;
            row++;
            col--;
        }
        return true;
    }
    public static void solve(int col, int n)
    {
        if(col==n){
            ArrayList<String> oneResult = new ArrayList<String>();
            for(int i=0; i<a.length; i++)
            {
                oneResult.add(new String(a[i]));
            }
            res.add(oneResult);
            return;
        }
        for(int i=0; i<n; i++)
        {
            if(isValid(i, col, n))
            {
                a[i][col] = 'Q';
                solve(col+1, n);
                a[i][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<List<String>>();
        a = new char[n][n];
        for(int i=0; i<n; i++)for(int j=0; j<n; j++)a[i][j] = '.';
        solve(0, n);
        return res;
    }
}
