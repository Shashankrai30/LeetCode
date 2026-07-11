class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int i=1;
        int j=0;

        for(int num:nums){
            j=Math.max(num,j);
        }
        

        while(i<=j){
            int mid= i+(j-i)/2;
            int sum=0;

            for(int ind=0;ind<nums.length;ind++){
                if(nums[ind]%mid==0){
                    sum=sum+nums[ind]/mid;
                }
                else{
                    sum=sum+nums[ind]/mid+1;
                }
            }

            if(sum<=threshold){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }

        return i;
    }
}