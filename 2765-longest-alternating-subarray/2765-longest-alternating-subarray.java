class Solution {
    public int alternatingSubarray(int[] nums) {
        
        int count=0;
        int ans=0;

        int last=0;

        int i=0;

        while(i+1<nums.length){
            int res=nums[i+1]-nums[i];
            if(count==0){
                if(res==1){
                    count++;
                    last=res;
                    ans=Math.max(ans,count+1);
                }
                i++;
            }
            else{
                if(res==last*-1){
                    count++;
                    last=res;
                    ans=Math.max(ans,count+1);
                    i++;
                }
                else{
                    count=0;
                }
            }
        }

        return (ans>0)?ans:-1;
    }
}