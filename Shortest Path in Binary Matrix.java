class Solution {
    int adjacent[][] = new int[][]{{0, 1}, {0, -1},
                                 {1, 0}, {-1, 0},
                                 {1, 1}, {-1, -1},
                                 {1, -1}, {-1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)return -1;
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int level = 1;
        int n;
        while(!q.isEmpty())
        {
            n = q.size();
            for(int it=0; it!=n; it++)
            {
                int head[] = q.poll();
                int x = head[0], y=head[1];
                if(x==grid.length-1&&y==grid[0].length-1)
                {
                    return level;
                }
                for(int it2=0; it2!=8; it2++)
                {
                    int newX = x+adjacent[it2][0];
                    int newY = y+adjacent[it2][1];

                    if(newX>=0 && newY>=0 && newX<grid.length && newY<grid[0].length && grid[newX][newY]==0)
                    {
                        q.add(new int[]{newX, newY});
                        grid[newX][newY] = 1;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
