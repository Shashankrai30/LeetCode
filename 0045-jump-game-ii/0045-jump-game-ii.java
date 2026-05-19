class Solution {
    public int jump(int[] nums) {
        Integer dp[]=new Integer[nums.length+1];
       return helper(0,nums,dp); 
    }

    int helper(int i,int nums[],Integer dp[]){

        if(i==nums.length-1) return 0;
        if(i>=nums.length) return Integer.MAX_VALUE/2;

        if(dp[i]!=null) return dp[i];

        int ans=Integer.MAX_VALUE/2;

        for(int jump=1;jump<=nums[i];jump++){
            ans=Math.min(ans,helper(i+jump,nums,dp));
        }

        return dp[i]=1+ans;
    }
}