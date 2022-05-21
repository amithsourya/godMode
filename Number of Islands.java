class Solution {
    int directions[][] = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public void dfs(char[][] grid, int i, int j)
    {
        for(int k=0; k<4; k++)
        {
            int nx = i+directions[k][0];
            int ny = j+directions[k][1];
            if(nx>=0&&ny>=0&&nx<grid.length&&ny<grid[0].length)
            {
                if(grid[nx][ny]=='1')
                {
                    grid[nx][ny] = '0';
                    dfs(grid, nx, ny);
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int result = 0;
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                if(grid[i][j]=='1')
                {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }
}
