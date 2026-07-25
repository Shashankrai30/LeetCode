class Solution {
    int fsum;
    public int findTargetSumWays(int[] nums, int target) {
       fsum=0;
       for(int n:nums){
        fsum+=n;
       }
       Integer dp[][] = new Integer[nums.length][2*fsum+2];
       return helper(0,0,nums,target,dp); 
    }

    int helper(int i,int sum,int nums[],int target,Integer dp[][]){
        
        if(i==nums.length){
            if(sum==target) return 1;
            return 0;
        }

        if(dp[i][sum+fsum]!=null) return dp[i][sum+fsum];
        int take=helper(i+1,sum+nums[i],nums,target,dp);
        int skip=helper(i+1,sum-nums[i],nums,target,dp);

        return dp[i][sum+fsum] = take+skip;
    }
}