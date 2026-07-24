class Solution {
    public int numDecodings(String s) {
        
        Integer dp[] = new Integer[s.length()+1];
        return helper(0,s,dp);
        
    }

    int helper(int i,String s,Integer dp[]){

        if(i==s.length()) return 1;

        if(s.charAt(i)=='0') return 0;

        if(dp[i]!=null) return dp[i];

        int one = helper(i+1,s,dp);

        int two=0;

        if(i+1<s.length()){
            int temp=Integer.valueOf(s.substring(i,i+2));
            if(temp<=26){
                two=helper(i+2,s,dp);
            }
        }
        return dp[i] = one+two;
    }
}