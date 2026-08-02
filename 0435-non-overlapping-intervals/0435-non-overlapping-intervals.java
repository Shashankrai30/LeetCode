class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       Arrays.sort(intervals,(a,b)->a[0]-b[0]);
       Integer dp[] = new Integer[intervals.length];
       return intervals.length - helper(0,intervals,dp);
    }

    int helper(int i,int intervals[][], Integer dp[]){

        if(i==intervals.length) return 0;

        if(dp[i]!=null) return dp[i];

        int start=i+1;
        int end=intervals.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(intervals[mid][0]>=intervals[i][1]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }

        int take = 1 + helper(start,intervals,dp);
        int skip = helper(i+1,intervals,dp);

        return dp[i] = Math.max(take,skip);
    }
}