class Solution {
    public int numDecodings(String s) {
        Integer dp[] = new Integer[s.length()+1];
        return helper(0,s,dp);
        
    }

    int helper(int i,String s,Integer dp[]){

        if(i==s.length()) return 1;

        if(s.charAt(i)=='0') return 0;

        if(dp[i]!=null) return dp[i];

        long one = 0;

        if(s.charAt(i)=='*'){
            one=(9L*helper(i+1,s,dp))%1_000_000_007;
        }
        else{
            one=helper(i+1,s,dp);
        }

        long two=0;

        if(i+1<s.length()){
            if(s.charAt(i)=='*' && s.charAt(i+1)=='*'){
                two=(15L*helper(i+2,s,dp))%1_000_000_007;
            }
            else if(s.charAt(i)=='*'){
                if(s.charAt(i+1)-'0'<=6){
                    two=(2L*helper(i+2,s,dp))%1_000_000_007;
                }
                else{
                   two=helper(i+2,s,dp); 
                }
            }
            else if(s.charAt(i+1)=='*'){
                if(s.charAt(i)=='1'){
                    two=(9L*helper(i+2,s,dp))%1_000_000_007;
                }
                else if(s.charAt(i)=='2'){
                    two=(6L*helper(i+2,s,dp))%1_000_000_007;
                }
            }
            else{
                int temp=Integer.valueOf(s.substring(i,i+2));
                if(temp<=26){
                    two=helper(i+2,s,dp);
                }
            }
        }
        return dp[i] = (int)((one+two)%1_000_000_007);
    }
}