class Solution {
    public int findMin(int[] nums) {
        
        int i=0;
        int j=nums.length-1;

        while(i<=j){
            int mid=i+(j-i)/2;

            if(nums[mid]>nums[(mid+1)%nums.length] && nums[mid]> nums[(mid-1+nums.length)%nums.length]){
                return nums[(mid+1)%nums.length];
            }
            else if(nums[mid]>=nums[0] && nums[mid]>=nums[nums.length-1]){
                i=mid+1;            
            }
            else{
                j=mid-1;
            }
        }

        return nums[i%nums.length];
    }
}