class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Integer dp[] = new Integer[cost.length];

        return Math.min(helper(0,cost,dp),helper(1,cost,dp));
    }

    int helper(int i,int cost[],Integer dp[]){

        if(i==cost.length) return 0;

        if(i>cost.length) return Integer.MAX_VALUE/2;

        if(dp[i]!=null) return dp[i];

        int one=helper(i+1,cost,dp);
        int two=helper(i+2,cost,dp);

        return dp[i] = cost[i] + Math.min(one,two);
    }
}