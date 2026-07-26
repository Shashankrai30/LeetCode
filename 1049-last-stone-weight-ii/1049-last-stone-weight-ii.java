class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int n:stones){
            sum+=n;
        }
        Integer dp[][] = new Integer[stones.length][2*sum+2];
        return helper(0,0,stones,dp,sum);
    }

    int helper(int i,int sum,int stones[],Integer dp[][],int tsum){

        if(i==stones.length){
            return Math.abs(sum);
        }

        if(dp[i][sum+tsum]!=null) return dp[i][sum+tsum];

        int add = helper(i+1,sum+stones[i],stones,dp,tsum);
        int sub = helper(i+1,sum-stones[i],stones,dp,tsum);

        return dp[i][sum+tsum] = Math.min(add,sub);

    }
}