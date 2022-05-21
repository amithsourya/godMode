class Solution {
    int directions[][] = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public void floodFill(char[][] grid, int i, int j)
    {
        for(int k=0; k<4; k++)
        {
            int nx = i+directions[k][0];
            int ny = j+directions[k][1];
            if(nx>=0&&ny>=0&&nx<grid.length&&ny<grid[0].length)
            {
                if(grid[nx][ny]=='O')
                {
                    grid[nx][ny] = '-';
                    floodFill(grid, nx, ny);
                }
            }
        }
    }
    public void solve(char[][] board) {
        for(int j=0; j<board[0].length; j++)
        {
            if(board[0][j]=='O')
            {
                board[0][j] = '-';
                floodFill(board, 0, j);
            }
            if(board[board.length-1][j]=='O')
            {
                board[board.length-1][j] = '-';
                floodFill(board, board.length-1, j);
            }
        }
        for(int i=0; i<board.length; i++)
        {
            if(board[i][0]=='O')
            {
                board[i][0]='-';
                floodFill(board, i, 0);
            }
            if(board[i][board[0].length-1]=='O')
            {
                board[i][board[0].length-1]='-';
                floodFill(board, i, board[0].length-1);
            }
        }
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(board[i][j]=='-')board[i][j]='O';
                else board[i][j] = 'X';
            }
        }
    }
}
