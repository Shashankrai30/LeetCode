class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long ans=0;

        for(int i=nums.length-1;i>nums.length-1-k;i--){
            if(mul>0){
                ans=ans+(long)nums[i]*mul;
                mul--;
            }
            else{
                ans=ans+nums[i];
            }
        }

        return ans;
    }
}