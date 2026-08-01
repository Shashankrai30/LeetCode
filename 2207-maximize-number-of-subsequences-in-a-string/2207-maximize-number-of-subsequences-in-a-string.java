class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        HashMap<Character,Long> map = new HashMap<>();
        map.put(pattern.charAt(0),0L);
        map.put(pattern.charAt(1),0L);

        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
           
            map.put(ch,map.getOrDefault(ch,0L)+1L);
        }
        Long dp[][] = new Long[text.length()][2];
        long ans=helper(0,0,text,pattern,dp);

        return ans+Math.max(map.get(pattern.charAt(0)),map.get(pattern.charAt(1)));
    }

    long helper(int i,int j,String text,String Pat,Long dp[][]){

        if(j==Pat.length()){
            return 1 ;
        }

        if(i==text.length()){
            return 0;
        }

        if(dp[i][j]!=null) return dp[i][j];

        long take=0;
        if(text.charAt(i)==Pat.charAt(j)){
            take = helper(i+1,j+1,text,Pat,dp);
        }

        return dp[i][j] = take + helper(i+1,j,text,Pat,dp) ;
    }
}