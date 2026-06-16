class Solution {
    public int jump(int[] nums) {
        Integer dp[]=new Integer[nums.length+1];
        return helper(0,nums,dp);
    }

    int helper(int ind,int nums[],Integer dp[]){

        if(ind==nums.length-1) return 0;

        if(ind>=nums.length) return Integer.MAX_VALUE/2;

        if(dp[ind]!=null) return dp[ind];

        int ans=Integer.MAX_VALUE/2;

        for(int i=1;i<=nums[ind];i++){

            ans=Math.min(ans,helper(ind+i,nums,dp));
        }

        return dp[ind] = ans+1;
    }
}