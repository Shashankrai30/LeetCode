class Solution {
    public int numDistinct(String s, String t) {
       Integer dp[][] = new Integer[s.length()][t.length()];
       return helper(0,0,s,t,dp); 
    }

    int helper(int i,int j,String s,String t,Integer dp[][]){

        if(j==t.length()){
            return 1;
        }

        if(i==s.length()){
            return 0;
        }

        if(dp[i][j]!=null) return dp[i][j];

        int take=0;

        if(s.charAt(i)==t.charAt(j)){
            take=helper(i+1,j+1,s,t,dp);
        }

        return dp[i][j] = take+helper(i+1,j,s,t,dp);
    }
}