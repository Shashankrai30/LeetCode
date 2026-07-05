class Solution {
    public int uniquePaths(int m, int n) {
        Integer dp[][] = new Integer[m][n];

        return helper(0,0,m,n,dp);
    }

    int helper(int row,int col,int m,int n,Integer dp[][]){

        if(row==m || col==n) return 0;

        if(row==m-1 && col==n-1){
            return 1;
        }

        if(dp[row][col]!=null) return dp[row][col];

        int down= helper(row+1,col,m,n,dp);
        int right=helper(row,col+1,m,n,dp);

        return dp[row][col] = down+right;
    }
}