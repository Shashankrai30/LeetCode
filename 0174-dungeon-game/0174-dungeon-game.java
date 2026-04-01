class Solution {
    public int calculateMinimumHP(int[][] d) {
        Integer dp[][]=new Integer[d.length][d[0].length];
        return solve(0,0,d.length,d[0].length,d,dp);
    }
    public static int solve(int i,int j,int m,int n,int [][]power,Integer dp[][]){
        if(i>=m || j>=n){
            return (int )1e9;
        }
        if(i==m-1 && j==n-1){
            if(power[i][j]>0){
                return 1;
            }
            else{
                return Math.abs(power[i][j])+1;
            }
        }
        if(dp[i][j]!=null)return dp[i][j];
        int down=solve(i+1,j,m,n,power,dp);
        int right=solve(i,j+1,m,n,power,dp);
        int need=Math.min(down,right)-power[i][j];
        return dp[i][j]=(need<=0)? 1:need;
    }
}