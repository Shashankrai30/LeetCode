class Solution {
    public int jump(int[] nums) {
        Integer dp[] = new Integer[nums.length];
        return helper(0,nums,dp);
    }

    int helper(int ind,int nums[],Integer dp[]){

        if(ind==nums.length-1) return 0;

        if(ind>=nums.length) return Integer.MAX_VALUE/2;

        if(dp[ind]!=null) return dp[ind];

        int min=Integer.MAX_VALUE/2;

        for(int i=1;i<=nums[ind];i++){
            min=Math.min(min,helper(ind+i,nums,dp));
        }

        return dp[ind] = 1+min;
    }
}