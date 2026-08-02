class Solution {
    public int videoStitching(int[][] clips, int time) {

        Arrays.sort(clips,(a,b)->a[0]-b[0]);
        Integer dp[][] = new Integer[clips.length][time+1];
        int ans = helper(0,0,clips,time,dp);
        return (ans>=Integer.MAX_VALUE/2)?-1:ans;
    }

    int helper(int i,int range,int clips[][],int time,Integer dp[][]){

        if(range>=time){
            return 0;
        }

        if(i==clips.length){
            return Integer.MAX_VALUE/2;
        }

        if(dp[i][range]!=null) return dp[i][range];

        int take=Integer.MAX_VALUE/2;
        int skip=Integer.MAX_VALUE/2;
        if( clips[i][1]>range && clips[i][0]<=range){
            take= 1 + helper(i+1,clips[i][1],clips,time,dp);
           
        }

        skip = helper(i+1,range,clips,time,dp);

        return dp[i][range] = Math.min(take,skip);
    }
}