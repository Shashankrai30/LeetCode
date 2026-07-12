class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)-> a[0]-b[0]);

        Integer dp[] = new Integer[pairs.length];

        return helper(0,pairs,dp);
    }

    int helper(int ind,int pairs[][],Integer dp[]){

        if(ind==pairs.length) return 0;

        if(dp[ind]!=null) return dp[ind];

        int i=ind;
        int j=pairs.length-1;

        while(i<=j){
            int mid=i+(j-i)/2;

            if(pairs[mid][0]>pairs[ind][1]){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }

        int take=1+helper(i,pairs,dp);
        int skip=helper(ind+1,pairs,dp);

        return dp[ind] = Math.max(take,skip);
    }

}