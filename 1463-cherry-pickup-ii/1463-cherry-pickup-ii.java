class Solution {
    public int cherryPickup(int[][] grid) {
        Integer dp[][][][]=new Integer[grid.length][grid[0].length][grid.length][grid[0].length];

        return helper(0,0,0,grid[0].length-1,grid,dp);
    }

    int helper(int row1,int col1,int row2,int col2,int grid[][],Integer dp[][][][]){
        if(row1>=grid.length || col1>=grid[0].length || row2>=grid.length || col2>=grid[0].length || row1<0 || col1<0 || row2<0 || col2<0){
            return Integer.MIN_VALUE/2;
        }
        if(grid[row1][col1]==-1 || grid[row2][col2]==-1) return Integer.MIN_VALUE/2;

        if(row1 == grid.length - 1) {
            if(col1 == col2) return grid[row1][col1];
            return grid[row1][col1] + grid[row2][col2];
        }

        if(dp[row1][col1][row2][col2]!=null) return dp[row1][col1][row2][col2];

        int cherry=grid[row1][col1];
        if(col1 != col2){
            cherry += grid[row2][col2];
        }

        int best = Integer.MIN_VALUE;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                best=Math.max(best,(helper(row1+1,col1+i,row2+1,col2+j,grid,dp)));
            }
        }
        return dp[row1][col1][row2][col2]=cherry+best;
    }
}