class Solution {
    public int findMin(int[] nums) {
      int i=0;
      int j=nums.length-1;

      int rotated=0;
      boolean found=false;

      while(i<=j){
        int mid=i+(j-i)/2;

        if((mid-1>=0 && nums[mid]>nums[mid-1]) && (mid+1<nums.length && nums[mid]>nums[mid+1])){
            rotated=mid;
            found=true;
            break;
        }
        else if(nums[mid]>=nums[0] && nums[mid]>=nums[nums.length-1]){
            i=mid+1;
        }
        else{
            j=mid-1;
        }
      }  

      if(!found){
        rotated=j%nums.length;
      }

      return nums[rotated+1%nums.length];
    }
}