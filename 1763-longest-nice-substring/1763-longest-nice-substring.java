class Solution {
    public String longestNiceSubstring(String s) {
       String ans="";

       for(int i=0;i<s.length();i++){
        for(int j=i;j<s.length();j++){
            String temp=s.substring(i,j+1);
            if(helper(temp)){
                if(temp.length()>ans.length()){
                    ans=temp;
                }
            }
        }
       } 

       return ans;
    }
    boolean helper(String temp){
        for(char ch:temp.toCharArray()){
            if(ch<97){
                if(!temp.contains(String.valueOf((char)(ch+32)))){
                    return false;
                }
            }
            else{
                if(!temp.contains(String.valueOf((char)(ch-32)))){
                    return false;
                }
            }
        }

        return true;
    }
}