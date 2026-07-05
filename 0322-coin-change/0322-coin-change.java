class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer dp[][] = new Integer[coins.length][amount+1];
        int ans=helper(0,amount,coins,dp);
        return (ans>=Integer.MAX_VALUE/2)?-1:ans;
    }

    int helper(int i,int amount,int coins[],Integer dp[][]){

        if(amount==0) return 0;

        if(amount<0 || i==coins.length){
            return Integer.MAX_VALUE/2;
        }

        if(dp[i][amount]!=null) return dp[i][amount];

        int take=1+helper(i,amount-coins[i],coins,dp);
        int skip=helper(i+1,amount,coins,dp);

        return dp[i][amount] = Math.min(take,skip);
    }
}