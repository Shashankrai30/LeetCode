class Solution {
    public int splitArray(int[] nums, int k) {
        
        int start=0;
        int end=0;

        for(int n:nums){
            start=Math.max(start,n);
            end+=n;
        }

        while(start<=end){
            int mid=start+(end-start)/2;

            int split=0;
            int sum=0;

            for(int n:nums){
                if(sum+n<=mid){
                    sum+=n;
                }
                else{
                   split++;
                   sum=n; 
                }
            }

            if(split+1<=k){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
}