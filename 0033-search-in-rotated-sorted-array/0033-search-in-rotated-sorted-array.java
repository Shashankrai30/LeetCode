class Solution {
    public int search(int[] nums, int target) {

    //   if(nums.length==1){
    //     return (nums[0]==target)?0:-1;
    //   }
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

      i=0;
      j=rotated;

      while(i<=j){
        int mid=i+(j-i)/2;

        if(nums[mid]==target){
            return mid;
        }
        else if(nums[mid]<target){
            i=mid+1;
        }
        else{
            j=mid-1;
        }
      }

      i=rotated+1;
      j=nums.length-1;

      while(i<=j){
        int mid=i+(j-i)/2;

        if(nums[mid]==target){
            return mid;
        }
        else if(nums[mid]<target){
            i=mid+1;
        }
        else{
            j=mid-1;
        }
      }

      return -1;

    }
}