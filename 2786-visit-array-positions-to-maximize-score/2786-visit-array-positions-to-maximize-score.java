class Solution {
    public long maxScore(int[] nums, int x) {
      Long dp[][] = new Long[nums.length][2];
      return nums[0] + helper(1,nums[0]%2,nums,x,dp);  
    }

    long helper(int i,int prev,int nums[],int x,Long dp[][]){

        if(i==nums.length) return 0;

        if(dp[i][prev]!=null) return dp[i][prev];
        long take=0;
        if(nums[i]%2!=prev){
            take=-x;
        }

        take+=nums[i]+helper(i+1,nums[i]%2,nums,x,dp);
        long skip=helper(i+1,prev,nums,x,dp);

        return dp[i][prev] = Math.max(take,skip);
    }
}