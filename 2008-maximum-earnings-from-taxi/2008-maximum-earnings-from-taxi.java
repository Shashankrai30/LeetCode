class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides,(a,b)->a[0]-b[0]);

        Long dp[] = new Long[rides.length];

        return helper(0,rides,dp);
    }

    long helper(int ind,int rides[][],Long dp[]){

        if(ind==rides.length) return 0;

        if(dp[ind]!=null) return dp[ind];

        int i=ind;
        int j=rides.length-1;

        while(i<=j){
            int mid=i+(j-i)/2;
            
            if(rides[mid][0]>=rides[ind][1]){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }

        long take=rides[ind][1]-rides[ind][0]+rides[ind][2]+helper(i,rides,dp);
        long skip = helper(ind+1,rides,dp);

        return dp[ind] = Math.max(take,skip);
    }
}