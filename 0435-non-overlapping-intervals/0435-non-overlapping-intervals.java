class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);

        Integer dp[] = new Integer[intervals.length];

        return intervals.length-helper(0,intervals,dp);
    }

    int helper(int ind,int intervals[][],Integer dp[]){

        if(ind==intervals.length) return 0;

        if(dp[ind]!=null) return dp[ind];

        int i=ind;
        int j=intervals.length-1;

        while(i<=j){
            int mid=i+(j-i)/2;

            if(intervals[mid][0]>=intervals[ind][1]){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }

        int take= 1+helper(i,intervals,dp);
        int skip=helper(ind+1,intervals,dp);

        return dp[ind] = Math.max(take,skip);
    }
}