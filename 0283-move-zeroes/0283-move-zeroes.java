class Solution {
    public void moveZeroes(int[] nums) {
        
        int i=0;

        while(i<nums.length){
            if(nums[i]==0){
                int j=i+1;
                while(j<nums.length && nums[j]==0){
                    j++;
                }
                if(j<nums.length){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
                
            }
            i++;
        }

        
        return;
    }
}