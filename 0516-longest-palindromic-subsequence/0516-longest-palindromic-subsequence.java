class Solution {
    public int longestPalindromeSubseq(String s) {
        String reverse = new StringBuilder(s).reverse().toString();

        Integer dp[][] = new Integer[s.length()][s.length()];

        return helper(0,0,s,reverse,dp);
    }

    int helper(int i,int j,String s,String s1,Integer dp[][]){
        if(i==s.length() || j==s1.length()){
            return 0;
        }

        if(dp[i][j]!=null)  return dp[i][j];

        if(s.charAt(i)==s1.charAt(j)){
            return dp[i][j] = 1+helper(i+1,j+1,s,s1,dp);
        }

        return dp[i][j] = Math.max(helper(i+1,j,s,s1,dp),helper(i,j+1,s,s1,dp));
    }
}