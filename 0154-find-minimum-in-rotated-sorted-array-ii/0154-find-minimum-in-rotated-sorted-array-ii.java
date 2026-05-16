class Solution {
    public int findMin(int[] nums) {
        int ans=nums[0];

        for(int num:nums){
            ans=Math.min(num,ans);
        }

        return ans;
    }
}