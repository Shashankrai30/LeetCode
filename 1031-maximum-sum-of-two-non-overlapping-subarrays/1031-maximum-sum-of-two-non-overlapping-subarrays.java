class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        
        int leftmax[] = new int[nums.length];

        int rightmax[] = new int[nums.length];

        for(int i=0;i<firstLen;i++){
            leftmax[i] = nums[i];

            if(i==firstLen-1){
                int curr=0;
                for(int ind=0;ind<firstLen;ind++){
                    curr+=nums[ind];
                }
                leftmax[i] = curr;
            }
        }

        for(int i=firstLen;i<nums.length;i++){

            int curr=0;

            for(int ind=i;ind>i-firstLen;ind--){
                curr+=nums[ind];
            }

            leftmax[i] = Math.max(leftmax[i-1],curr);
        }

        
        for(int i=nums.length-1;i>=nums.length-secondLen;i--){
            rightmax[i] = nums[i];

            if(i==nums.length-secondLen){
                int curr=0;
                for(int ind=i;ind<i+secondLen;ind++){
                    curr+=nums[ind];
                }
                rightmax[i] = curr;
            }
        }

        for(int i=nums.length-secondLen-1;i>=0;i--){

            int curr=0;

            for(int ind=i;ind<i+secondLen;ind++){
                curr+=nums[ind];
            }

            rightmax[i] = Math.max(rightmax[i+1],curr);
        }

        int leftmax1[] = new int[nums.length];

        int rightmax1[] = new int[nums.length];

        for(int i=0;i<secondLen;i++){
            leftmax1[i] = nums[i];

            if(i==secondLen-1){
                int curr=0;
                for(int ind=0;ind<secondLen;ind++){
                    curr+=nums[ind];
                }
                leftmax1[i] = curr;
            }
        }

        for(int i=secondLen;i<nums.length;i++){

            int curr=0;
            for(int ind=i;ind>i-secondLen;ind--){
                curr+=nums[ind];
            }

            leftmax1[i] = Math.max(leftmax1[i-1],curr);
        }

        
        for(int i=nums.length-1;i>=nums.length-firstLen;i--){
            rightmax1[i] = nums[i];

            if(i==nums.length-firstLen){
                int curr=0;
                for(int ind=i;ind<i+firstLen;ind++){
                    curr+=nums[ind];
                }
                rightmax1[i] = curr;
            }
        }

        for(int i=nums.length-firstLen-1;i>=0;i--){

            int curr=0;

            for(int ind=i;ind<i+firstLen;ind++){
                curr+=nums[ind];
            }

            rightmax1[i] = Math.max(rightmax1[i+1],curr);
        }

        int ans=0;

        for(int i=0;i<nums.length-1;i++){
            ans=Math.max(ans,leftmax[i]+rightmax[i+1]);
            ans=Math.max(ans,leftmax1[i]+rightmax1[i+1]);
        }

        return ans;
    }
}