class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int i=0;
        while((i<nums.length ) &&(nums[i]%2!=0 || nums[i]>threshold)){
            i++;
        }

        if(i==nums.length) return 0;
        int j=i;

        int max=j-i+1;

        while(j<nums.length-1){
            if(nums[j]%2!=nums[j+1]%2 && nums[j]<=threshold){
                j++;
                if(nums[j]<=threshold){
                    max=Math.max(max,j-i+1);
                }
            }
            else{
                j++;
                while((j<nums.length ) &&(nums[j]%2!=0 || nums[j]>threshold)){
                    j++;
                }
                i=j;
            }
        }

        return max;
    }
}