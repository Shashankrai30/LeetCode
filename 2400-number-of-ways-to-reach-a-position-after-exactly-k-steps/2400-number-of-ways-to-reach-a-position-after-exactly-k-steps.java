class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        Integer dp[][] = new Integer[2*(startPos+k)][k+1];
        return helper(startPos,endPos,k,1,dp,startPos+k)%1_000_000_007;
    }

    int helper(int start,int end,int step,int jump, Integer dp[][],int s){

        if(step==0){
            if(start==end) return 1;
            else return 0;
        }

        if(dp[start+s][step]!=null) return dp[start+s][step];

        return dp[start+s][step] = (helper(start+jump,end,step-1,jump,dp,s)+helper(start-jump,end,step-1,jump,dp,s))%1_000_000_007;
    }
}