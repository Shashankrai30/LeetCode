class Solution {
    public String longestPalindrome(String s) {
        String ans="";

        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String temp=s.substring(i,j+1);
                if(ispallindrome(temp) && temp.length()>ans.length()){
                    ans=temp;
                }
            }
        }

        return ans;
    }

    boolean ispallindrome(String s){
        int start=0;
        int end=s.length()-1;

        while(start<end){
            char st=s.charAt(start);
            char en=s.charAt(end);

            if(st==en){
                start++;
                end--;
            }
            else{
                return false;
            }
        }

        return true;
    }
}