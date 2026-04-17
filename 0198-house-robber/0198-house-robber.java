class Solution {
    public int rob(int[] nums) {
        int dp[]=new int [nums.length];
        Arrays.fill(dp,-1);
        if(nums.length==1) return dp[0]= nums[0];
        if(nums.length==2) return dp[1]= Math.max(nums[0],nums[1]);

        dp[0]= nums[0];
        dp[1]= Math.max(nums[0],nums[1]);
        return helper(nums.length-1,nums,dp);
    }

    int helper(int i,int nums[],int dp[]){
        if(i<2) return dp[i];
        if(i==2){
            if(nums[2]+dp[0]>dp[1]){
                return dp[2]=nums[2]+dp[0];
            }
            return dp[2]=dp[1];
        }
        
        if(dp[i]!=-1) return dp[i];

        if(nums[i]+helper(i-2,nums,dp)>helper(i-1,nums,dp)){
            return dp[i]=nums[i]+helper(i-2,nums,dp);
        }
        else{
            return dp[i]=helper(i-1,nums,dp);
        }
    }

}