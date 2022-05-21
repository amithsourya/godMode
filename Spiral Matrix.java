class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> ll = new LinkedList<>();
        int directions[][] = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int nums = matrix[0].length*matrix.length;
        int i = 0, j = 0, k=0;
        while(nums>0)
        {
            ll.add(matrix[i][j]);
            int nx = i + directions[k][0];
            int ny = j + directions[k][1];
            if(nx<0||ny<0||nx>=matrix.length||ny>=matrix[0].length||matrix[nx][ny]==101)
            {
                k = (k+1)%4;
                nx = i + directions[k][0];
                ny = j + directions[k][1];
            }
            matrix[i][j] = 101;
            i = nx;
            j = ny;
            nums--;
        }
        return ll;
    }
}
