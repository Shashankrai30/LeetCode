class Solution {
    int MOD=1_000_000_007;
    int min;
    int m;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        m=group.length;
        min=minProfit; 
        Integer[][][] dp=new Integer[m+1][minProfit+1][n+1];
        return solve(0,0,n,group,profit,dp);
    }
    public int solve(int idx,int currProfit,int groupSize,int[] group,int[] profit,Integer[][][] dp){
        if(idx==m){
            if(currProfit>=min)
                return 1;
            return 0;
        }
         if(currProfit>=min){
            currProfit=min;
        }
        if(dp[idx][currProfit][groupSize]!=null) return dp[idx][currProfit][groupSize];

       
        int nottake=solve(idx+1,currProfit,groupSize,group,profit,dp);

        int take=0;
        if(group[idx]<=groupSize)
            take=solve(idx+1,currProfit+profit[idx],groupSize-group[idx],group,profit,dp);
        return dp[idx][currProfit][groupSize] =(take+nottake) % MOD;
    }
}