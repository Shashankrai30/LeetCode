class Solution {
    public boolean canPartition(int[] nums) {

        int sum=0;

        for(int num:nums){
            sum=sum+num;
        }

        if(sum%2!=0) return false;

        Boolean dp[][] = new Boolean[nums.length][sum/2+1];

        return helper(0,nums,sum/2,dp);
        
    }
    boolean helper(int i,int nums[],int target,Boolean dp[][]){

        if(target==0) return true;

        if(target<0 || i==nums.length) return false;

        if(dp[i][target]!=null) return dp[i][target];

        boolean take=helper(i+1,nums,target-nums[i],dp);
        boolean skip=helper(i+1,nums,target,dp);

        return dp[i][target] = take|| skip;
    }
}