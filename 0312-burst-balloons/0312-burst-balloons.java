class Solution {
    public int maxCoins(int[] nums) {
      List<Integer> list = new ArrayList<>();
      list.add(1);

      for(int i=0;i<nums.length;i++){
        list.add(nums[i]);
      }  
      list.add(1);

      Integer dp[][] = new Integer[nums.length+2][nums.length+2];

      return helper(1,list.size()-2,list,dp);
    }

    int helper(int left,int right,List<Integer> list,Integer dp[][]){
        if(left>right){
            return 0;
        }

        if(dp[left][right]!=null) return dp[left][right];

        int ans=0;
        for(int i=left;i<=right;i++){
            int sum=list.get(left-1)*list.get(i)*list.get(right+1)+helper(left,i-1,list,dp)+helper(i+1,right,list,dp);

            ans=Math.max(ans,sum);
        }

        return dp[left][right] = ans;
    }
}