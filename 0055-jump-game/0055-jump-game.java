class Solution {
    public boolean canJump(int[] nums) {
        Boolean dp[]=new Boolean[nums.length+1];
       return helper(0,nums,dp); 
    }

    boolean helper(int i,int nums[],Boolean dp[]){
        if(i==nums.length-1) return true;

        if(i>=nums.length) return false;

        if(dp[i]!=null) return dp[i];

        for(int jump=1;jump<=nums[i];jump++){

            if(helper(i+jump,nums,dp)){
                return dp[i] = true;
            }
        }

        return dp[i] = false;
    }
}