class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if(n<d) return -1;
        Integer dp[][]=new Integer[n][d+1];

        return helper(0,d,jobDifficulty,dp);
    }

    int helper(int i,int d,int job[],Integer dp[][]){

        if(d==1){
            int max=0;
            for(int ind=i;ind<job.length;ind++){
                max=Math.max(max,job[ind]);
            }

            return max;
        }

        if(dp[i][d]!=null) return dp[i][d];

        int ans=Integer.MAX_VALUE;
        int max=0;

        for(int ind=i;ind<=job.length-d;ind++){
            max=Math.max(max,job[ind]);

            int next=helper(ind+1,d-1,job,dp);

            ans=Math.min(ans,max+next);
        }

        return dp[i][d]=ans;
    }
}