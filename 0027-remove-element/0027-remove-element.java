class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length==0) return 0;
        if(nums.length==1) return (nums[0]==val)?0:1;
       int i=0; 
       int j=nums.length-1;
       int count=0;

       while(i<=j){
        if(nums[i]==val && nums[j]!=val){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
            count++;
        }
        else{
            if(nums[j]==val){
                j--;
                count++;
            }
            if(nums[i]!=val){
                i++;
            }
        }       

       }

       return nums.length-count;
    }
}