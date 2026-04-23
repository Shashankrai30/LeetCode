class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer dp[][] = new Integer[nums.length+1][nums.length+1];
        return helper(0,-1,nums,dp);
    }

    int helper(int idx,int prev,int nums[], Integer dp[][] ){
        if(idx==nums.length) return 0;

        if(dp[prev+1][idx]!=null) return dp[prev+1][idx];

        int take=0;
        if(prev==-1 || nums[idx]>nums[prev]){
            take=1+helper(idx+1,idx,nums,dp);
        }

        int skip=helper(idx+1,prev,nums,dp);

        return dp[prev+1][idx]=Math.max(skip,take);
    }
}