class Solution {
    public int jobScheduling(int[] start, int[] end, int[] profit) {

        int n = start.length;

        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = start[i];
            jobs[i][1] = end[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            start[i] = jobs[i][0];
            end[i] = jobs[i][1];
            profit[i] = jobs[i][2];
        }

        
        
        Integer dp[] = new Integer[profit.length];
        return helper(0,start,end,profit,dp);
    }

    int helper(int ind,int start[],int endTime[],int profit[],Integer dp[]){

        if(ind==profit.length) return 0;

        if(dp[ind]!=null) return dp[ind];

        
        int j=start.length-1;
        int i=ind;

        while(i<=j){
            int mid=i+(j-i)/2;

            if(start[mid]>=endTime[ind]){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }

        int take=profit[ind]+helper(i,start,endTime,profit,dp);

        int skip = helper(ind+1,start,endTime,profit,dp);

        return dp[ind] =  Math.max(take,skip);
    }
}