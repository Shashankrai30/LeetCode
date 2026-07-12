class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int i=1;
        int j=0;

        for(int n:nums){
            j=Math.max(n,j);
        }

        while(i<=j){
            int mid=i+(j-i)/2;

            long count=0;

            for(int ind=0;ind<nums.length;ind++){
                int temp;
                if(nums[ind]%mid==0){
                    temp=nums[ind]/mid;
                }
                else{
                    temp=nums[ind]/mid+1;
                }
                count+=temp-1;
            }

            if(count>maxOperations){
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }

        return i;
    }
}