class Solution {
    int ans;
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        ans=0;
        Integer dp[][] = new Integer[nums1.length][3];
        helper(0,-1,nums1,nums2,dp);
        return ans;
    }

    int helper(int i,int choose,int nums1[],int nums2[],Integer dp[][]){

        if(i==nums1.length){
            return 0;
        }

        if(dp[i][choose+1]!=null) return dp[i][choose+1];

        helper(i+1,-1,nums1,nums2,dp);

        int take1=0;
        int take2=0;

        if(choose==-1){
            take1=1+helper(i+1,0,nums1,nums2,dp);
            take2=1+helper(i+1,1,nums1,nums2,dp);

            int temp=Math.max(take1,take2);
            ans=Math.max(temp,ans);

            if(temp!=0){
                return dp[i][choose+1] = temp;
            }
        }
        else if(choose==0){
            if(nums1[i]>=nums1[i-1]){
                take1=1+helper(i+1,0,nums1,nums2,dp);
            }
            if(nums2[i]>=nums1[i-1]){
                take2=1+helper(i+1,1,nums1,nums2,dp);
            }

            int temp=Math.max(take1,take2);
            ans=Math.max(temp,ans);

            if(temp!=0){
                return dp[i][choose+1] = temp;
            }
        }
        else{
            if(nums1[i]>=nums2[i-1]){
                take1=1+helper(i+1,0,nums1,nums2,dp);
            }
            if(nums2[i]>=nums2[i-1]){
                take2=1+helper(i+1,1,nums1,nums2,dp);
            }

            int temp=Math.max(take1,take2);
            ans=Math.max(temp,ans);

            if(temp!=0){
                return dp[i][choose+1] = temp;
            }
        }

        return dp[i][choose+1] = 0;
    }
}