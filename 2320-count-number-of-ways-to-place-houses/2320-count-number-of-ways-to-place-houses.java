class Solution {
    public int countHousePlacements(int n) {
       Integer dp[][] = new Integer[n+1][2];

       long ans = helper(1,0,n,dp)%1_000_000_007;
       return (int)((ans*ans)%1_000_000_007); 
    }

    int helper(int i,int prev,int n,Integer dp[][]){

        if(i==n+1) return 1;

        if(dp[i][prev]!=null) return dp[i][prev];

        if(prev==1){
            return dp[i][prev] = helper(i+1,0,n,dp)%1_000_000_007;
        }

        int place =  helper(i+1,1,n,dp);
        int empty =  helper(i+1,0,n,dp);

        return dp[i][prev] = (place+empty)%1_000_000_007;
    }
}