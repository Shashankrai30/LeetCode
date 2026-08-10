class Solution {
    public int stoneGameII(int[] piles) {
        Integer dp[][][] = new Integer[piles.length][101][2];
        return helper(0,1,0,piles,dp);
    }

    int helper(int i,int m,int turn,int piles[],Integer dp[][][]){

        if(i==piles.length) return 0;

        if(dp[i][m][turn]!=null) return dp[i][m][turn];

        if(turn == 0){

            int take=0;
            int ans=0;

            for(int x=1;x<=2*m && i+x-1<piles.length;x++){

                ans+= piles[i+x-1];
                take=Math.max(take,ans+helper(i+x,Math.max(x,m),1,piles,dp));
            }
            return dp[i][m][turn] = take;
        }
        else{
            int take=Integer.MAX_VALUE;

            for(int x=1;x<=2*m && i+x-1<piles.length;x++){

                take=Math.min(take,helper(i+x,Math.max(m,x),0,piles,dp));
            }
            return dp[i][m][turn] = take;
        }
    }
}