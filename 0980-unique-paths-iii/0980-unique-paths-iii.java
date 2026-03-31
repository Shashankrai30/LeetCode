class Solution {
    int totalCells = 0;

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int sr = 0, sc = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != -1) totalCells++;
                if(grid[i][j] == 1){
                    sr = i;
                    sc = j;
                }
            }
        }

        return helper(sr, sc, m, n, grid, 1);
    }

    int helper(int row, int col, int rowl, int coll, int grid[][], int count){
        if(row < 0 || col < 0 || row >= rowl || col >= coll || grid[row][col] == -1){
            return 0;
        }

        if(grid[row][col] == 2 && count==totalCells) return 1;

        int temp = grid[row][col];
        grid[row][col] = -1;

        int down = helper(row+1, col, rowl, coll, grid, count+1);
        int right = helper(row, col+1, rowl, coll, grid, count+1);
        int up = helper(row-1, col, rowl, coll, grid, count+1);
        int left = helper(row, col-1, rowl, coll, grid, count+1);

        grid[row][col] = temp;

        return down + right + up + left;
    }
}