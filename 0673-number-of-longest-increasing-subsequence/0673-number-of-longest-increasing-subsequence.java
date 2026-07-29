class Solution {
    class pair{
        int len;
        int count;
        public pair(int len,int count){
            this.len=len;
            this.count=count;
        }
    }
    public int findNumberOfLIS(int[] nums) {
        pair dp[][] = new pair[nums.length][nums.length+1];

        pair ans=helper(0,-1,nums,dp);

        return ans.count;

        
    }

    pair helper(int i,int prev,int nums[],pair dp[][]){

        if(i==nums.length){
            return new pair(0,1);
        }

        if(dp[i][prev+1]!=null) return dp[i][prev+1];

        pair take=new pair(0,0);

        if(prev==-1 || nums[i]>nums[prev]){
            pair next = helper(i+1, i, nums, dp);
            take = new pair(next.len + 1, next.count);
        }

        pair skip=helper(i+1,prev,nums,dp);

        if(take.len>skip.len){
            return dp[i][prev+1] = take;
        }
        else if(take.len<skip.len){
            return dp[i][prev+1] = skip;
        }
        else{
            pair ans=new pair(0,0);
            ans.len=take.len;
            ans.count=take.count+skip.count;

            return dp[i][prev+1] = ans;
        }
    }
}