class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer dp[][] = new Integer[nums.length][nums.length+1];
        return helper(0,-1,nums,dp);
    }

    int helper(int i,int prev,int nums[],Integer dp[][]){

        if(i==nums.length){
            return 0;
        }

        if(dp[i][prev+1]!=null) return dp[i][prev+1];

        int take=0;

        if(prev==-1 || nums[prev]<nums[i]){
            take=1+helper(i+1,i,nums,dp);
        }

        int skip=helper(i+1,prev,nums,dp);

        return dp[i][prev+1] = Math.max(take,skip);
    }
}