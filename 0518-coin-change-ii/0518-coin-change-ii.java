class Solution {
    public int change(int amount, int[] coins) {
        Integer dp[][] = new Integer[coins.length][amount+1];
        return helper(0,coins,amount,dp);
    }

    int helper(int i,int coins[],int amount,Integer dp[][]){

        if(amount==0){
            return 1;
        }

        if(i==coins.length || amount<0){
            return 0;
        }

        if(dp[i][amount]!=null) return dp[i][amount];

        int take=helper(i,coins,amount-coins[i],dp);
        int skip=helper(i+1,coins,amount,dp);

        return dp[i][amount] = skip+take;
    }
}