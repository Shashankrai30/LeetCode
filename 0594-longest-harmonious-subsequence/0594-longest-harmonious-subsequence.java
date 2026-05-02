class Solution {
    public int findLHS(int[] nums) {
        int i=0;
        int j=0;

        Arrays.sort(nums);

        int ans=0;

        while(j<nums.length){
            if(nums[j]-nums[i]==1){
                ans=Math.max(ans,j-i+1);
                j++;
            }
            else if(nums[j]-nums[i]>1){
                 i++;
            }
            else{
                j++;
            }
        }
        return ans;
    }
}