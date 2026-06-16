class Solution {
    public int minDistance(String word1, String word2) {
        Integer dp[][] =new Integer[word1.length()+1][word2.length()+1];
        return helper(0,0,word1,word2,dp);
    }

    int helper(int i,int j,String word1,String word2,Integer dp[][]){
        if(i==word1.length() && j==word2.length()){
            return 0;
        }

        if(i==word1.length()){
            return word2.length()-j;
        }

        if(j==word2.length()){
            return word1.length()-i;
        }

        if(dp[i][j]!=null) return dp[i][j];

        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j] = helper(i+1,j+1,word1,word2,dp);
        }

        int insert=helper(i,j+1,word1,word2,dp);
        int delete=helper(i+1,j,word1,word2,dp);
        int replace=helper(i+1,j+1,word1,word2,dp);

        return dp[i][j] = 1 + Math.min(insert,Math.min(delete,replace));
    }
}