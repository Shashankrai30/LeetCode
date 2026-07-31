class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        Integer dp[][] = new Integer[text1.length()][text2.length()];
        return helper(0,0,text1,text2,dp);
    }

    int helper(int i,int j,String text1,String text2,Integer dp[][]){

        if(i==text1.length() || j==text2.length()){
            return 0;
        }

        if(dp[i][j]!=null) return dp[i][j];

        if(text1.charAt(i)==text2.charAt(j)){
            return dp[i][j] = 1+helper(i+1,j+1,text1,text2,dp);
        }

        return dp[i][j] = Math.max(helper(i+1,j,text1,text2,dp),helper(i,j+1,text1,text2,dp));
    }
}