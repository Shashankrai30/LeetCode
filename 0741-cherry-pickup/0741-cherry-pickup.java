class Solution {
    public int cherryPickup(int[][] grid) {
        if(grid.length==1 && grid[0].length==1){
            return(grid[0][0]==1)?1:0;
        }
       Integer dp[][][][]=new Integer[grid.length][grid[0].length][grid.length][grid[0].length];
       int ans=helper(0,0,0,0,grid,dp);
       return (ans>0)? ans:0;
    }

    int helper(int row1,int col1,int row2,int col2,int[][] grid,Integer dp[][][][]){
        if(row1>=grid.length || col1>=grid[0].length || row2>=grid.length || col2>=grid[0].length ){
            return Integer.MIN_VALUE/2;
        }
        if(grid[row1][col1]==-1 || grid[row2][col2]==-1) return Integer.MIN_VALUE/2;

        if(row1==grid.length-1 && col1==grid.length-1){
            return grid[row1][col1];
        }

        if(dp[row1][col1][row2][col2]!=null) return dp[row1][col1][row2][col2];

        int cherry=grid[row1][col1];
        if(row1!=row2){
            cherry+=grid[row2][col2];
        }

        int down1 = helper(row1+1,col1,row2+1,col2,grid,dp); 
        int right1 = helper(row1,col1+1,row2,col2+1,grid,dp); 
        int down2 = helper(row1+1,col1,row2,col2+1,grid,dp); 
        int right2 = helper(row1,col1+1,row2+1,col2,grid,dp); 

        return dp[row1][col1][row2][col2]=cherry+Math.max(down1,Math.max(right1,Math.max(down2,right2)));
    }
}