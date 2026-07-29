class Solution {
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        Integer dp[][] = new Integer[pairs.length][pairs.length+1];
        return helper(0,-1,pairs,dp);
    }

    int helper(int i,int prev,int pairs[][],Integer dp[][]){

        if(i==pairs.length){
            return 0;
        }

        if(dp[i][prev+1]!=null) return dp[i][prev+1];

        int take=0;

        if(prev==-1 || pairs[i][0]>pairs[prev][1]){
            take=1+helper(i+1,i,pairs,dp);
        }

        int skip=helper(i+1,prev,pairs,dp);

        return dp[i][prev+1] = Math.max(take,skip);
    }
}