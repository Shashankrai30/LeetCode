class Solution {
    public int minFallingPathSum(int[][] mat) {
      Integer dp[][]=new Integer[mat.length][mat[0].length];
        
        int max=Integer.MAX_VALUE;
        for(int i=0;i<mat[0].length;i++){
            dp[0][i]=helper(0,i,mat,dp);
            max=Math.min(max,dp[0][i]);
        }
        
        return max;
    }
    
    int helper(int row,int col,int mat[][], Integer dp[][]){
        if((row==mat.length || col==mat[0].length) || col<0) return Integer.MAX_VALUE/2;
        
        if(row==mat.length-1) return mat[row][col];
        
        if(dp[row][col]!=null) return dp[row][col];
        
        int leftdown=mat[row][col]+helper(row+1,col-1,mat,dp);
        int rightdown=mat[row][col]+helper(row+1,col+1,mat,dp);
        int down=mat[row][col]+helper(row+1,col,mat,dp);
        
        return dp[row][col]=Math.min(leftdown,Math.min(down,rightdown));
    }
}