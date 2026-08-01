class Solution {
    public boolean predictTheWinner(int[] nums) {
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        Integer dp[][][] = new Integer[nums.length][nums.length][2];
        int ans=helper(0,nums.length-1,0,nums,dp);

        return (ans>=sum*1.0/2.0)?true:false;
    }

    int helper(int i,int j,int turn,int nums[],Integer dp[][][]){

        if(i>j){
            return 0;
        }

        if(dp[i][j][turn]!=null) return dp[i][j][turn];

        if(turn%2==0){
            int left=nums[i]+helper(i+1,j,1,nums,dp);
            int right=nums[j]+helper(i,j-1,1,nums,dp);

            return dp[i][j][turn] = Math.max(left,right);
        }

        int left=helper(i+1,j,0,nums,dp);
        int right=helper(i,j-1,0,nums,dp);

        return dp[i][j][turn] = Math.min(left,right);
    }
}