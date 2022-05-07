class Solution {
    public int[][] adjacent(char[][]board, int i, int j)
    {
        int n = board.length;
        int m = board[0].length;
        int [][] res = new int[4][2];
        res[0][0] = i+1;
        res[0][1] = j;
        res[1][0] = i-1;
        res[1][1] = j;
        res[2][0] = i;
        res[2][1] = j+1;
        res[3][0] = i;
        res[3][1] = j-1;
        return res;
    }
    public boolean solve(char[][] board, String word, int ix, int j, int it)
    {
        char replace = board[ix][j];
        if(it==word.length()-1&&replace==word.charAt(it))return true;
        if(board[ix][j]==word.charAt(it))
        {
            board[ix][j] = '@';
            int[][] adj = adjacent(board, ix, j);
            for(int i=0; i<4; i++)
            {
                if(adj[i][0]>=0&&adj[i][0]<board.length&&adj[i][1]>=0&&adj[i][1]<board[0].length)
                {
                    if(solve(board, word, adj[i][0], adj[i][1], it+1))return true;
                }
            }
        }
        board[ix][j] = replace;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(solve(board, word, i, j, 0))return true;
            }
        }
        return false;
    }
}
