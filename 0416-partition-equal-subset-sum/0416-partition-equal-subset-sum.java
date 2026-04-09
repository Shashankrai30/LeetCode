class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum=sum+num;
        }

        if(sum%2!=0) return false;

        Boolean dp[][]=new Boolean[nums.length+1][sum+1];

        return helper(0,sum/2,nums,dp);
    }

    boolean helper(int i,int sum,int nums[], Boolean dp[][]){

        if(sum==0) return true;

        if(i==nums.length || sum<0) return false;

        if(dp[i][sum]!=null) return dp[i][sum];

        boolean take=helper(i+1,sum-nums[i],nums,dp);
        boolean skip=helper(i+1,sum,nums,dp);

        return dp[i][sum]= take||skip;
    }
}