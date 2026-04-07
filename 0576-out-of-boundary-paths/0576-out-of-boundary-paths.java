class Solution {
    long MOD=1_000_000_007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer dp[][][]=new Integer[m][n][maxMove+1];

        return helper(startRow,startColumn,m,n,maxMove,dp);
    }

    int helper(int row,int col,int m,int n,int max,Integer dp[][][]){
        if(row<0 || col<0 || row>=m || col>=n){
            return 1;
        }

        if(max==0) return 0;

        if(dp[row][col][max]!=null) return dp[row][col][max];

        long down=helper(row+1,col,m,n,max-1,dp);
        long up=helper(row-1,col,m,n,max-1,dp);
        long right=helper(row,col+1,m,n,max-1,dp);
        long left=helper(row,col-1,m,n,max-1,dp);

        return dp[row][col][max]=(int)((long)(down+up+right+left)%MOD);
    }

}