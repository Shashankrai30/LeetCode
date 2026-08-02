class Solution {
    public boolean stoneGame(int[] piles) {

        int sum=0;
        for(int p:piles){
            sum+=p;
        }
        Integer dp[][][] = new Integer[piles.length][piles.length][2];
        int ans=helper(0,piles.length-1,0,piles,dp);
        return (ans>=sum*1.0/2.0)?true:false;
    }

    int helper(int i,int j,int turn,int piles[],Integer dp[][][]){
        if(i>j){
            return 0;
        }

        if(dp[i][j][turn]!=null) return dp[i][j][turn];

        if(turn%2==0){
            int left=piles[i]+helper(i+1,j,1,piles,dp);
            int right=piles[j]+helper(i,j-1,1,piles,dp);

            return dp[i][j][turn] = Math.max(left,right);
        }

        int left=helper(i+1,j,0,piles,dp);
        int right=helper(i,j-1,0,piles,dp);

        return dp[i][j][turn] = Math.max(left,right);
    }
}