class Solution {
    public int minCut(String s) {
        Integer dp[] = new Integer[s.length()+1];
        return helper(0,s,dp)-1;
    }

    int helper(int i,String s,Integer dp[]){

        if(i==s.length()) return 0;

        if(dp[i]!=null) return dp[i];

        int ans=Integer.MAX_VALUE;
        for(int ind=i;ind<s.length();ind++){
            if(pallindrome(i,ind,s)){
                int temp=1+helper(ind+1,s,dp);
                ans=Math.min(ans,temp);
            }
        }
       
        return dp[i] = ans;

    }

    boolean pallindrome(int i,int j,String s){

        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}